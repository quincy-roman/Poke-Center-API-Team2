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
import com.revature.repository.PokeRepo;
import com.revature.repository.TrainerRepo;

@Service("TrainerService")
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepo trainerRepo;
	
	@Autowired
	private PokeRepo pokeRepo;

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
	public boolean registerPatient(PatientDTO patientDTO, Pokemon pokemon) {
		// if the Pokemon exists, don't save, otherwise, save.
		if(trainerRepo.getPokemon(pokemon.getName()) == null) {
			pokeRepo.save(pokemon);
		}

		Timestamp admission = new Timestamp(System.currentTimeMillis());
	
		Trainer trainer = trainerRepo.getTrainerId(patientDTO.getTrainersId());
		
		StatusCondition status = trainerRepo.getStatus(patientDTO.getStatusId());
		
		// Set the objects to the new patient.
		Patient patient = new Patient(pokemon, trainer, admission, patientDTO.getCurrentHP(), 
									  patientDTO.getMaxHP(), status, null, null, false, null);
		
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
											 p.getStatus().getStatusId(), 0, 
											 p.isHealthy());
			if(p.getMed() != null) {
				pdto.setMedId(p.getMed().getMedID());
			}
			patientDTOs.add(pdto);
		}
		return patientDTOs;
	}

}
