package com.revature.service;

import java.util.List;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.model.dto.PatientDTO;

public interface TrainerService {

	List<PatientDTO> getPokemon(Trainer trainer);

	Trainer getProfile(Trainer trainer);

	Trainer updateProfile(Trainer trainer);

	public boolean registerTrainer(Trainer trainer);

}
