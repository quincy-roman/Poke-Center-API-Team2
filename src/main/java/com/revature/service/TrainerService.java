package com.revature.service;

import java.util.List;

import com.revature.model.Patient;
import com.revature.model.Trainer;

public interface TrainerService {

	public boolean registerPatient(Patient patient);

	List<Patient> getPokemon(Trainer trainer);

	Trainer getProfile(Trainer trainer);

	Trainer updateProfile(Trainer trainer);

	public boolean registerTrainer(Trainer trainer);

}
