package com.cruize.vessel.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class VesselItenaory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vessel_itenoryId;
	
	public int getVessel_itenoryId() {
		return vessel_itenoryId;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date journeyDate;
	
	private int duration;
	
	private String source;
	
	private String destination;
	
	private int avilablity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vessel_id")
	private Vessel vessel;

	public VesselItenaory( String journeyDate, int duration, String source, String destination,
			int avilablity, Vessel vessel) {
		super();
		this.journeyDate = Date.valueOf(journeyDate);
		this.duration = duration;
		this.source = source;
		this.destination = destination;
		this.avilablity = avilablity;
		this.vessel = vessel;
	}

	public VesselItenaory() {
	}
	
	

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = Date.valueOf(journeyDate);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getAvilablity() {
		return avilablity;
	}

	public void setAvilablity(int avilablity) {
		this.avilablity = avilablity;
	}

	public Vessel getVessel() {
		return vessel;
	}

	public void setVessel(Vessel vessel) {
		this.vessel = vessel;
	}

	

}
