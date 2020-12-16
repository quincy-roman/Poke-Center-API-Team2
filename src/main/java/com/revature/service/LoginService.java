package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.model.Trainer;
import com.revature.model.dto.EmployeeDTO;
import com.revature.model.dto.TrainerDTO;
import com.revature.repository.LoginRepository;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepo;
	
	public LoginService() {}
	
	public EmployeeDTO loginEmployee(String username, String password) {
		Employee e = loginRepo.loginEmployee(username, password);
		EmployeeDTO employee = null;
		
		if(e.getRole().getRoleid() == 1) {
			employee = new EmployeeDTO(e.getEmployeeId(), e.getUsername(), e.getPassword(), e.getEmployeeName(), 1);
		}else if(e.getRole().getRoleid() == 2) {
			employee = new EmployeeDTO(e.getEmployeeId(), e.getUsername(), e.getPassword(), e.getEmployeeName(), 2);
		}
		
		return employee;
	}
	
	public TrainerDTO loginTrainer(String username, String password) {
		Trainer t = loginRepo.loginTrainer(username, password);
		TrainerDTO trainer = new TrainerDTO(t.getTrainerId(), t.getTrainerName(), t.getHometown(), t.getUsername(), t.getPassword());
		return trainer;
	}

}
