package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;
import com.revature.repo.PokeRepo;

@Service("PokeService")
public class PokeServiceImpl implements PokeService {

	private static Logger log = Logger.getLogger(PokeServiceImpl.class);

	@Autowired
	private PokeRepo pokeRepo;

	public PokeServiceImpl() {
		System.out.println("WORKED 1");
	}

	@Override
	public boolean registerPokemon(Pokemon pokemon) {
		pokeRepo.save(pokemon);
		return pokemon.getDexid() != 0;
	}
	
	@Override
	public boolean registerStatus(StatusCondition statusCondition) {
		pokeRepo.save(statusCondition);
		return statusCondition.getStatusId() != 0;
	}

	@Override
	public boolean registerMedicine(Medicine med) {
		pokeRepo.save(med);
		return med.getMedID() != 0;

	}

	@Override
	public boolean registerPatient(Patient patient) {
		pokeRepo.save(patient);		
		return patient.getPateintid() != 0;
	}
	
	@Override
	public boolean registerRole(Role role) {
		pokeRepo.save(role);
		return role.getRoleid() != 0;
	}

	@Override
	public boolean registerEmpl(Employee empl) {
		pokeRepo.save(empl);		
		return empl.getEmployeeId() != 0;
	}

	@Override
	public boolean registerTrainer(Trainer trainer) {
		pokeRepo.save(trainer);
		return trainer.getTrainerId() != 0;
	}

	@Override
	public boolean loginTrainer(String username, String password) {
		return pokeRepo.loginTrainer(username, password);
	}

	@Override
	public boolean loginEmpl(String username, String password) {
		return pokeRepo.loginEmpl(username, password);
	}
	
}