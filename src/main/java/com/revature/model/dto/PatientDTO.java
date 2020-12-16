package com.revature.model.dto;

import java.sql.Timestamp;

public class PatientDTO {
	
	private int patientid;
	private int pokemonDexId;
	private int trainersId;
	private Timestamp admission;
	private Timestamp release;
	private int currentHP;
	private int maxHP;
	private int statusId;
	private int medId;
	private boolean healthy;
	
	public PatientDTO() {}

	public PatientDTO(int patientid, int pokemonDexId, int trainersId, Timestamp admission, Timestamp release,
			int currentHP, int maxHP, int statusId, int medId, boolean healthy) {
		super();
		this.patientid = patientid;
		this.pokemonDexId = pokemonDexId;
		this.trainersId = trainersId;
		this.admission = admission;
		this.release = release;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.statusId = statusId;
		this.medId = medId;
		this.healthy = healthy;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public int getPokemonDexId() {
		return pokemonDexId;
	}

	public void setPokemonDexId(int pokemonDexId) {
		this.pokemonDexId = pokemonDexId;
	}

	public int getTrainersId() {
		return trainersId;
	}

	public void setTrainersId(int trainersId) {
		this.trainersId = trainersId;
	}

	public Timestamp getAdmission() {
		return admission;
	}

	public void setAdmission(Timestamp admission) {
		this.admission = admission;
	}

	public Timestamp getRelease() {
		return release;
	}

	public void setRelease(Timestamp release) {
		this.release = release;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

	@Override
	public String toString() {
		return "PatientDTO [patientid=" + patientid + ", pokemonDexId=" + pokemonDexId + ", trainersId=" + trainersId
				+ ", admission=" + admission + ", release=" + release + ", currentHP=" + currentHP + ", maxHP=" + maxHP
				+ ", statusId=" + statusId + ", medId=" + medId + ", healthy=" + healthy + ", getPatientid()="
				+ getPatientid() + ", getPokemonDexId()=" + getPokemonDexId() + ", getTrainersId()=" + getTrainersId()
				+ ", getAdmission()=" + getAdmission() + ", getRelease()=" + getRelease() + ", getCurrentHP()="
				+ getCurrentHP() + ", getMaxHP()=" + getMaxHP() + ", getStatusId()=" + getStatusId() + ", getMedId()="
				+ getMedId() + ", isHealthy()=" + isHealthy() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
