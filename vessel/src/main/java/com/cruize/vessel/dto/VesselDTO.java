package com.cruize.vessel.dto;

import javax.validation.constraints.NotNull;

public class VesselDTO {

	@NotNull
	private String name;
	@NotNull
	private String date;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public VesselDTO(@NotNull String name, @NotNull String date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	public VesselDTO(){}
	
	
}
