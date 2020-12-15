package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.service.NurseService;
import com.revature.util.ClientMessage;

@RestController
public class NurseController {
	
	@Autowired
	private NurseService nurseService;
	
	@PostMapping("/treatment")					
	public ResponseEntity<ClientMessage> treatement(@RequestBody Patient patient) {
		ClientMessage body = (nurseService.treatmentAndRelease(patient)) ? SUCCESSFULLY_TREATED : TREATMENT_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/getAllPatients")
	public  ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> patients = nurseService.getAllPatients();
		return ResponseEntity.ok(patients);
	}
	
	@PostMapping("/getMyPatients")
	public ResponseEntity<List<Patient>> getNursePatients(@RequestBody Employee nurse) {
		List<Patient> nursesPatients = nurseService.getNursePatients(nurse.getEmployeeId());
		return ResponseEntity.ok(nursesPatients);
	}
	
	@GetMapping("/getAllMedicine")
	public ResponseEntity<List<Medicine>> getAllMeds() {
		List<Medicine> medicines = nurseService.getAllMedicines();
		return ResponseEntity.ok(medicines);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ClientMessage> updateNurse(@RequestBody Employee nurse) {
		ClientMessage body = (nurseService.update(nurse)) ? SUCCESSFUL_UPDATE : FAILED_UPDATE;
		return ResponseEntity.ok(body);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ClientMessage> loginEmpl(@RequestBody String username, String password) {
		ClientMessage body = (nurseService.loginEmpl(username, password)) ? USER_LOGIN : LOGIN_FAILED;
		return ResponseEntity.ok(body);
	}
}
