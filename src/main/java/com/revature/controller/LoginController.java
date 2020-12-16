package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.dto.TrainerDTO;
import com.revature.model.dto.EmployeeDTO;
import com.revature.model.dto.LoginDTO;
import com.revature.service.LoginService;

@RestController
@RequestMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(path = "/employee", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<EmployeeDTO> loginEmployee(@RequestBody LoginDTO loginTemplate) {
		return ResponseEntity.ok(loginService.loginEmployee(loginTemplate.getUsername(), loginTemplate.getPassword()));
	}
	
	@PostMapping(path = "/trainer", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TrainerDTO> loginTrainer(@RequestBody LoginDTO loginTemplate) {
		return ResponseEntity.ok(loginService.loginTrainer(loginTemplate.getUsername(), loginTemplate.getPassword()));
	}
	

}
