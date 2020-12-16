package com.revature.service;

import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.repository.TrainerRepo;

@Service("TrainerService")
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepo trainerRepo;

	public TrainerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean registerTrainer(Trainer trainer) {
		try {
			trainerRepo.save(trainer);
			return trainer.getTrainerId() != 0;
		} catch (PSQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean registerPatient(Patient patient) {
		trainerRepo.save(patient);
		return patient.getPateintid() != 0;
	}

	@Override
	public Trainer getProfile(Trainer trainer) {
		return trainerRepo.getProfile(trainer);
	}

	@Override
	public Trainer updateProfile(Trainer trainer) {
		return trainerRepo.updateProfile(trainer);
	}

	@Override
	public List<Patient> getPokemon(Trainer trainer) {
		return trainerRepo.getPatient(trainer);
	}

}
