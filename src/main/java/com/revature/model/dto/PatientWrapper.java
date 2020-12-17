package com.revature.model.dto;

import com.revature.model.Pokemon;

public class PatientWrapper {
	
	private Pokemon pokemon;
	private PatientDTO patientDTO;
	private EmployeeDTO nurseDTO;
	
	public PatientWrapper() {}

	public PatientWrapper(PatientDTO patientDTO, Pokemon pokemon) {
		super();
		this.patientDTO = patientDTO;
		this.pokemon = pokemon;
	}

	public PatientDTO getPatientDTO() {
		return patientDTO;
	}

	public void setPatientDTO(PatientDTO patientDTO) {
		this.patientDTO = patientDTO;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public EmployeeDTO getNurseDTO() {
		return nurseDTO;
	}

	public void setNurseDTO(EmployeeDTO nurseDTO) {
		this.nurseDTO = nurseDTO;
	}

}
