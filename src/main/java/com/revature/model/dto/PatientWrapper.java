package com.revature.model.dto;

import com.revature.model.Pokemon;

public class PatientWrapper {
	
	private Pokemon pokemon;
	private PatientDTO patientDTO;
	
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

}
