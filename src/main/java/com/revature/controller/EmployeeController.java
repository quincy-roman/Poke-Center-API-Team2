package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.util.ClientMessage;

public interface EmployeeController {

	public ResponseEntity<List<Medicine>> getAllMedicines();

//	public ResponseEntity<ClientMessage> loginEmpl(String username, String password);

	public ResponseEntity<List<Patient>> getAllPatients();

}
