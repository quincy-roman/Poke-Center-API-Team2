package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.util.ClientMessage;

public interface TrainerController {

	ResponseEntity<List<Patient>> getPokemon(Trainer trainer);
	
//	ResponseEntity<ClientMessage> loginTrainer(String username, String password);

	ResponseEntity<Trainer> getProfile(Trainer trainer);

	ResponseEntity<Trainer> updateProfile(Trainer trainer);
	
	ResponseEntity<ClientMessage> registerTrainer(Trainer trainer);
	
	ResponseEntity<ClientMessage> admitPokemon(Patient patient);

}
