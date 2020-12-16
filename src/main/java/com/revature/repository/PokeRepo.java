package com.revature.repository;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;

public interface PokeRepo {

	void save(Pokemon pokemon);

	void save(Role role);

	void save(Employee empl);

	void save(StatusCondition statusCondition);

	void save(Medicine med);

}
