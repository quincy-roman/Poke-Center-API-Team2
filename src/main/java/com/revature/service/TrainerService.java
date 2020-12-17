package com.revature.service;

import java.util.List;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.TrainerDTO;

public interface TrainerService {

	List<PatientDTO> getPokemon(Trainer trainer);

	public boolean registerPatient(Patient patient, int trainer, String pokemon, String status);

	TrainerDTO getProfile(Trainer trainer);

	TrainerDTO updateProfile(Trainer trainer);

	public boolean registerTrainer(Trainer trainer);

}
