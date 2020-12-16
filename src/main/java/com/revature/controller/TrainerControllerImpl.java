package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.service.TrainerService;
import com.revature.util.ClientMessage;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerControllerImpl implements TrainerController {

	@Autowired
	private TrainerService trainerService;

	public TrainerControllerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@GetMapping("/trainer/pokemon")
	public ResponseEntity<List<Patient>> getPokemon(@RequestBody Trainer trainer) {
		List<Patient> pokemon = trainerService.getPokemon(trainer);
		return ResponseEntity.ok(pokemon);
	}
//
//	@Override
//	@PostMapping("/trainer/login")
//	public ResponseEntity<ClientMessage> loginTrainer(@RequestBody String username, String password) {
//		ClientMessage body = (trainerService.loginTrainer(username, password)) ? USER_LOGIN : LOGIN_FAILED;
//		return ResponseEntity.ok(body);
//	}

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
	@PostMapping("/trainer/save")
	public ResponseEntity<ClientMessage> registerTrainer(@RequestBody Trainer trainer) {
		ClientMessage body = (trainerService.registerTrainer(trainer)) ? USER_LOGIN : LOGIN_FAILED;;
		return ResponseEntity.ok(body);
	}

	@Override
	public ResponseEntity<ClientMessage> admitPokemon(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

}
