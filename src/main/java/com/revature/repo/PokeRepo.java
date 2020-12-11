package com.revature.repo;

import com.revature.model.Employee;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.Trainer;

public interface PokeRepo {

	void save(Pokemon pokemon);

	void save(Trainer trainer);

	boolean loginTrainer(String username, String password);

	void save(Role role);

	void save(Employee empl);

	boolean loginEmpl(String username, String password);

}
