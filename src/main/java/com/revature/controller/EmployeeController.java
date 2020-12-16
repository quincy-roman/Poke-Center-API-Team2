package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Medicine;
import com.revature.model.Patient;

public interface EmployeeController {

	public ResponseEntity<List<Medicine>> getAllMedicines();

	public ResponseEntity<List<Patient>> getAllPatients();

}
