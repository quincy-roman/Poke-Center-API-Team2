package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.service.TrainerService;
import com.revature.util.ClientMessage;

@RestController
@RequestMapping(path = "/trainer", consumes = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerControllerImpl implements TrainerController {

	@Autowired
	private TrainerService trainerService;

	public TrainerControllerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@GetMapping("/trainer/pokemon/get")
	public ResponseEntity<List<Patient>> getPokemon(@RequestBody Trainer trainer) {
		List<Patient> pokemon = trainerService.getPokemon(trainer);
		return ResponseEntity.ok(pokemon);
	} 

	@Override
	@GetMapping("/trainer/profile")
	public ResponseEntity<Trainer> getProfile(@RequestBody Trainer trainer) {
		Trainer t = trainerService.getProfile(trainer);
		return ResponseEntity.ok(t);
	}

	@Override
	@PutMapping("/trainer/update")
	public ResponseEntity<Trainer> updateProfile(@RequestBody Trainer trainer) {
		Trainer t = trainerService.updateProfile(trainer);
		return ResponseEntity.ok(t);
	}

	@Override
	@PostMapping(path = "/registration", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> registerTrainer(@RequestBody Trainer trainer) {
		ClientMessage body = (trainerService.registerTrainer(trainer)) ? USER_LOGIN : LOGIN_FAILED;
		return ResponseEntity.ok(body);
	}

	@Override
	@PostMapping("/trainer/pokemon/admit")
	public ResponseEntity<ClientMessage> admitPokemon(Patient patient) {
		ClientMessage body = (trainerService.registerPatient(patient)) ? USER_LOGIN : LOGIN_FAILED;
		return ResponseEntity.ok(body);
	}

}
