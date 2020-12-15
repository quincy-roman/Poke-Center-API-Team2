package com.revature.repository;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;

public interface PokeRepo {

	void save(Pokemon pokemon);

	void save(Trainer trainer);

	void save(Role role);

	void save(Employee empl);

	void save(StatusCondition statusCondition);

	void save(Medicine med);
	
	void save(Patient patient);

	boolean loginTrainer(String username, String password);

	boolean loginEmpl(String username, String password);

}
