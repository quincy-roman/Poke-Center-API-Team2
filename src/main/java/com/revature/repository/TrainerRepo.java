package com.revature.repository;

import java.util.List;

import org.postgresql.util.PSQLException;

import com.revature.model.Patient;
import com.revature.model.Trainer;

public interface TrainerRepo {

	List<Patient> getPatient(Trainer trainer);

	Trainer getProfile(Trainer trainer);

	Trainer updateProfile(Trainer trainer);

	void save(Trainer trainer) throws PSQLException;

	void save(Patient patient);

}
