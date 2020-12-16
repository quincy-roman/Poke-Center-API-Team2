package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.model.Trainer;
import com.revature.model.dto.LoginDTO;
import com.revature.service.LoginService;

@RestController
@RequestMapping("/login/employee")
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public ResponseEntity<Employee> loginEmployee(@RequestBody LoginDTO loginTemplate) {
		return ResponseEntity.ok(loginService.loginEmployee(loginTemplate.getUsername(), loginTemplate.getPassword()));
	}
	
//	@PostMapping("/trainer")
//	public ResponseEntity<Trainer> loginTrainer(@RequestBody LoginDTO loginTemplate) {
//		return ResponseEntity.ok(loginService.loginTrainer(loginTemplate.getUsername(), loginTemplate.getPassword()));
//	}
	

}
