package com.revature.model.dto;

public class TreatmentWrapper {
	
	private int patientid;
	private int medid;
	
	public TreatmentWrapper() {	}

	public TreatmentWrapper(int patientid, int medid) {
		super();
		this.patientid = patientid;
		this.medid = medid;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public int getMedid() {
		return medid;
	}

	public void setMedid(int medid) {
		this.medid = medid;
	}
	
	

}
