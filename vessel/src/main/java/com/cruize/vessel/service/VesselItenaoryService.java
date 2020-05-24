package com.cruize.vessel.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cruize.vessel.dto.VesselItrDTO;
import com.cruize.vessel.model.Vessel;
import com.cruize.vessel.model.VesselItenaory;
import com.cruize.vessel.repo.VesselItenaoryRepository;
import com.cruize.vessel.repo.VesselRepository;

@Service
public class VesselItenaoryService {
	@Autowired
	private VesselItenaoryRepository repo;

	@Autowired
	private VesselRepository vesselRepo;

	public List<VesselItenaory> findAll(Map<String, String> params) {

		if(params== null || params.isEmpty()){
			 List<VesselItenaory> resultList = repo
					  .findAll();
			 return resultList;
		}
		
		Iterator<String> iterator = params.keySet().iterator();
		VesselItenaory itenaory = new VesselItenaory();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = params.get(key);
			if (value != null) {
				switch (key) {
				case "source":
					itenaory.setSource(value);
					break;
				case "destination":
					itenaory.setDestination(value);
					break;
				case "journeyDate":
					itenaory.setJourneyDate(value);
					break;
				case "avilablity":
					itenaory.setAvilablity(Integer.parseInt(value));
					break;
				default:
					break;
				}
			}
		}

		 
		List<VesselItenaory> resultList = repo.findAll(new Specification<VesselItenaory>() {

			@Override
			public Predicate toPredicate(Root<VesselItenaory> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				Predicate p = builder.conjunction();
				if (itenaory != null) {

					if (Objects.nonNull(itenaory.getJourneyDate())) {
						p = builder.and(p, builder.equal(root.get("journeyDate"), itenaory.getJourneyDate()));
					}
					if (Objects.nonNull(itenaory.getDestination())) {
						p = builder.and(p, builder.equal(root.get("destination"), itenaory.getDestination()));
					}
					if (Objects.nonNull(itenaory.getSource())) {
						p = builder.and(p, builder.equal(root.get("source"), itenaory.getSource()));
					}
					if (itenaory.getAvilablity() > 0) {
						p = builder.and(p,
								builder.greaterThanOrEqualTo(root.get("avilablity"), itenaory.getAvilablity()));
					}
				}

				return p;
			}
		}

		);
		if (resultList == null || resultList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No cruise found!"));
		} else {
			return resultList;
		}
	}


	public String decrementAvialablity(HashMap<String, Integer> params) {
		int id = params.get("vessel_itenoryId");
		int availablity = params.get("avilablity");
		Optional<VesselItenaory> itrOptional = repo.findById(id);

		VesselItenaory itr = itrOptional.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Vessel doesn't exist!")));
		itr.setAvilablity(itr.getAvilablity() - availablity);
		repo.save(itr);
		return "Updated sucessfully";
	}

	public void createItenaory(@Valid VesselItrDTO itenaory) {
		Optional<Vessel> vesselOptional = vesselRepo.findById(itenaory.getVesselId());

		Vessel vessel = vesselOptional.orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Vessel doesn't exist!")));

		VesselItenaory vessel_ir = new VesselItenaory();
		vessel_ir.setAvilablity(itenaory.getAvilablity());
		vessel_ir.setDestination(itenaory.getDestination());
		vessel_ir.setDuration(itenaory.getDuration());
		vessel_ir.setJourneyDate(itenaory.getJourneyDate());
		vessel_ir.setSource(itenaory.getSource());
		vessel_ir.setVessel(vessel);

		repo.save(vessel_ir);
	}

	public VesselItenaory findItenaoryByID(int id) {
		return repo.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Vessel doesn't exist!")));
	}
}
