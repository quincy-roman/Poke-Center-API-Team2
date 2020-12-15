package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.service.TrainerService;

@RestController
public class TrainerControllerImpl implements  TrainerController{
	
	@Autowired
	private TrainerService trainerService;

	public TrainerControllerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@GetMapping("/trainerpokemon")
	public @ResponseBody List<Patient> getPokemon(@RequestBody Trainer trainer) {
		return trainerService.getPokemon(trainer);
	}

	@Override
	@PostMapping("/logintrainer")
	public boolean loginTrainer(String username, String password) {
		return trainerService.loginTrainer(username, password);
	}

	@Override
	@GetMapping("/profiletrainer")
	public @ResponseBody Trainer getProfile(@RequestBody Trainer trainer) {
		return trainerService.getProfile(trainer);
	}

	@Override
	@PutMapping("/updatetrainerprofile")
	public @ResponseBody Trainer updateProfile(@RequestBody Trainer trainer) {
		return trainerService.updateProfile(trainer);
	}

	@Override
	@PostMapping("/savetrainer")
	public @ResponseBody boolean registerTrainer(@RequestBody Trainer trainer) {
		// TODO Auto-generated method stub
		return trainerService.registerTrainer(trainer);
	}
	
	

}
