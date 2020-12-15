package com.revature.service;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;

public interface PokeService {
	
	public boolean registerPokemon(Pokemon pokemon);

	public boolean registerTrainer(Trainer trainer);
	
	public boolean registerRole(Role nurse);

	public boolean registerEmpl(Employee n);

	public boolean registerStatus(StatusCondition statusCondition);

	public boolean registerMedicine(Medicine med);

	public boolean registerPatient(Patient patient);
}
