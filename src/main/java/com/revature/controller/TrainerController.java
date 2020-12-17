package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Trainer;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.PatientWrapper;
import com.revature.model.dto.TrainerDTO;
import com.revature.util.ClientMessage;

public interface TrainerController {

	ResponseEntity<List<PatientDTO>> getPokemon(Trainer trainer);

	ResponseEntity<TrainerDTO> getProfile(Trainer trainer);

	ResponseEntity<TrainerDTO> updateProfile(Trainer trainer);

	ResponseEntity<ClientMessage> registerTrainer(Trainer trainer);

	ResponseEntity<ClientMessage> admitPokemon(PatientWrapper patientData);

}
