package com.revature.repository;

import java.util.List;

import com.revature.model.Patient;
import com.revature.model.Trainer;

public interface TrainerRepo {

	boolean loginTrainer(String username, String password);

	List<Patient> getPatient(Trainer trainer);

	Trainer getProfile(Trainer trainer);

	Trainer updateProfile(Trainer trainer);

	void save(Trainer trainer);

}
