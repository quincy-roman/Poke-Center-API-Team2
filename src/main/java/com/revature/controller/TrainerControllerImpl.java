package com.revature.controller;

import static com.revature.util.ClientMessageUtil.PATIENT_FAILED;
import static com.revature.util.ClientMessageUtil.PATIENT_REGISTERED;
import static com.revature.util.ClientMessageUtil.USER_NOT_REGISTERED;
import static com.revature.util.ClientMessageUtil.USER_REGISTERED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Trainer;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.PatientWrapper;
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
	@PostMapping(path = "/table/view-my-pokemon", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<PatientDTO>> getPokemon(@RequestBody Trainer trainer) {
		System.out.println("\n"+ trainer.toString()+"\n");
		List<PatientDTO> pokemon = trainerService.getPokemon(trainer);
		return ResponseEntity.ok(pokemon);
	}

	@Override
	@PostMapping(path = "/profile", consumes = {MediaType.APPLICATION_JSON_VALUE})
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
	public ResponseEntity<ClientMessage> admitPokemon(@RequestBody PatientWrapper patientData) {
		ClientMessage body = (trainerService.registerPatient(patientData.getPatientDTO(), patientData.getPokemon())) ? PATIENT_REGISTERED : PATIENT_FAILED;
		return ResponseEntity.ok(body);
	}

}
