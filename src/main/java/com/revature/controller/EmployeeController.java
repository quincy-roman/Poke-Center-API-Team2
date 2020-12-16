package com.revature.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Employee;

import com.revature.model.dto.MedicineDTO;
import com.revature.model.dto.PatientDTO;
import com.revature.util.ClientMessage;

public interface EmployeeController {

	public ResponseEntity<List<MedicineDTO>> getAllMedicines();

	public ResponseEntity<List<PatientDTO>> getAllPatients();
	
	public ResponseEntity<ClientMessage> register(Employee emp);

}
