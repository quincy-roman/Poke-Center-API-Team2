package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.repository.TrainerRepo;

@Service("TrainerService")
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	private TrainerRepo trainerRepo;
	
	public TrainerServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Patient> getPokemon(Trainer trainer) {
		return trainerRepo.getPatient(trainer);
	}

	@Override
	public boolean loginTrainer(String username, String password) {
		return trainerRepo.loginTrainer(username, password);
	}

	@Override
	public Trainer getProfile(Trainer trainer) {
		// TODO Auto-generated method stub
		return trainerRepo.getProfile(trainer);
	}

	@Override
	public Trainer updateProfile(Trainer trainer) {
		// TODO Auto-generated method stub
		return trainerRepo.updateProfile(trainer);
	}

}
