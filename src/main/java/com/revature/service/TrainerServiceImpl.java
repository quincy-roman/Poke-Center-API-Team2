package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.TrainerDTO;
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
		trainerRepo.save(trainer);
		return trainer.getTrainerId() != 0;
	}

	@Override
	public TrainerDTO getProfile(Trainer trainer) {
		Trainer t = trainerRepo.getProfile(trainer);
		TrainerDTO trainerDTO = new TrainerDTO(t.getTrainerId(), t.getTrainerName(), 
											   t.getHometown(), t.getUsername(), t.getPassword());
		return trainerDTO;
	}

	@Override
	public TrainerDTO updateProfile(Trainer trainer) {
		Trainer t = trainerRepo.updateProfile(trainer);
		TrainerDTO trainerDTO = new TrainerDTO(t.getTrainerId(), t.getTrainerName(), 
				   							   t.getHometown(), t.getUsername(), t.getPassword());
		return trainerDTO;
	}

	@Override
	public List<PatientDTO> getPokemon(Trainer trainer) {
		List<Patient> pokemon = trainerRepo.getPatient(trainer);
		List<PatientDTO> patientDTOs = new ArrayList<>();
		for(Patient p : pokemon) {
			PatientDTO pdto = new PatientDTO(p.getPateintid(), p.getPokemon().getDexid(), 
											 p.getTrainer().getTrainerId(), p.getAdmission(), 
											 p.getRelease(), p.getCurrentHP(), p.getMaxHP(), 
											 p.getStatus().getStatusId(), p.getMed().getMedID(), 
											 p.isHealthy());
			patientDTOs.add(pdto);
		}
		return patientDTOs;
	}

}
