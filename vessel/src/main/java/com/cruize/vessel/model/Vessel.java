package com.cruize.vessel.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@NoArgsConstructor

public class Vessel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vessel_id")
	private int id;
	
	public int getId() {
		return id;
	}

	@Column(nullable = false)
	private String name;
	   
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date manufacturingDate;  

	public Vessel(String name, String manufacturingDate) {
		super();
		this.name = name;
		this.manufacturingDate = Date.valueOf(manufacturingDate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = Date.valueOf(manufacturingDate);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((manufacturingDate == null) ? 0 : manufacturingDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vessel other = (Vessel) obj;
		if (id != other.id)
			return false;
		if (manufacturingDate == null) {
			if (other.manufacturingDate != null)
				return false;
		} else if (!manufacturingDate.equals(other.manufacturingDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Vessel() {
		super();
	}
	
	
	
}
