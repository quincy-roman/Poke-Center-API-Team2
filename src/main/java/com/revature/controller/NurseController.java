package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.service.NurseService;
import com.revature.util.ClientMessage;

@RestController
public class NurseController {
	
	// TODO Update to use ResponseEntity return type.
	
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
	public List<Patient> getNursePatients(@RequestBody Employee nurse) {
		return nurseService.getNursePatients(nurse.getEmployeeId());
	}
	
	@GetMapping("/getAllMedicine")
	public List<Medicine> getAllMeds() {
		return nurseService.getAllMedicines();
	}
	
	@PostMapping("/update")
	public ClientMessage updateNurse(@RequestBody Employee nurse) {
		return (nurseService.update(nurse)) ? SUCCESSFUL_UPDATE : FAILED_UPDATE;
	}
	
	// TODO implement login function here.

}
