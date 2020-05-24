package com.cruize.vessel.dto;

public class VesselItrDTO {
	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
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

	public int getVesselId() {
		return vesselId;
	}

	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}

	private String journeyDate;
	private int duration;
	private String source;
	private String destination;
	private int avilablity;
	private int vesselId;

	public VesselItrDTO(String journeyDate, int duration, String source, String destination, int avilablity,
			int vesselId) {
		super();
		this.journeyDate = journeyDate;
		this.duration = duration;
		this.source = source;
		this.destination = destination;
		this.avilablity = avilablity;
		this.vesselId = vesselId;
	}

	public VesselItrDTO() {
	}

}
