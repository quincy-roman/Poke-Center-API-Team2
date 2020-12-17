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

import com.revature.model.Pokemon;
import com.revature.model.Trainer;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.TrainerDTO;
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
	@GetMapping("/table/view-my-pokemon")
	public ResponseEntity<List<PatientDTO>> getPokemon(@RequestBody Trainer trainer) {
		List<PatientDTO> pokemon = trainerService.getPokemon(trainer);
		return ResponseEntity.ok(pokemon);
	} 

	@Override
	@GetMapping("/profile")
	public ResponseEntity<TrainerDTO> getProfile(@RequestBody Trainer trainer) {
		TrainerDTO t = trainerService.getProfile(trainer);
		return ResponseEntity.ok(t);
	}

	@Override
	@PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TrainerDTO> updateProfile(@RequestBody Trainer trainer) {
		TrainerDTO t = trainerService.updateProfile(trainer);
		return ResponseEntity.ok(t);
	}

	@Override
	@PostMapping(path = "/registration", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> registerTrainer(@RequestBody Trainer trainer) {
		ClientMessage body = (trainerService.registerTrainer(trainer)) ? USER_REGISTERED : USER_NOT_REGISTERED;
		return ResponseEntity.ok(body);
	}

	@Override
	@PostMapping(path = "/admission", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> admitPokemon(PatientDTO patient, Pokemon pokemon) {
		ClientMessage body = (trainerService.registerPatient(patient, pokemon)) ? PATIENT_REGISTERED : PATIENT_FAILED;
		return ResponseEntity.ok(body);
	}

}
