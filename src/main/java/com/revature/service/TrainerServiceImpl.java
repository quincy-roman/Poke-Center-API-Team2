package com.revature.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.StatusCondition;
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
		try {
			trainerRepo.save(trainer);
			return trainer.getTrainerId() != 0;
		} catch (PSQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean registerPatient(Patient patient, int trainer, String pokemon, String status) {
		Trainer t = trainerRepo.getTrainerId(trainer);
		patient.setTrainer(t);
		
		Pokemon p = trainerRepo.getPokemon(pokemon);
		patient.setPokemon(p);
		
		StatusCondition s = trainerRepo.problem(status);
		patient.setStatus(s);
		
		Timestamp admission = new Timestamp(System.currentTimeMillis());
		patient.setAdmission(admission);

		trainerRepo.save(patient);
		return patient.getPateintid() != 0;
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
