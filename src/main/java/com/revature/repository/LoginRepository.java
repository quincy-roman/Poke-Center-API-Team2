package com.revature.repository;

import com.revature.model.Employee;
import com.revature.model.Trainer;

public interface LoginRepository {
	
	Employee loginEmployee(String username, String password);
	Trainer loginTrainer(String username, String password);
}
