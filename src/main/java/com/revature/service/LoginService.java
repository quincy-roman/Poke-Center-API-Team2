package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.model.Trainer;
import com.revature.repository.LoginRepository;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepo;
	
	public LoginService() {}
	
	public Employee loginEmployee(String username, String password) {
		return loginRepo.loginEmployee(username, password);
	}
	
	public Trainer loginTrainer(String username, String password) {
		return loginRepo.loginTrainer(username, password);
	}
	
	public <T> boolean logoutUser(T user) {
		return loginRepo.logoutUser(user);
	}

}
