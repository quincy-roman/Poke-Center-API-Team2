package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.service.NurseService;
import com.revature.util.ClientMessage;

@Controller
@CrossOrigin()
public class NurseController {
	
	@Autowired
	private NurseService nurseService;
	
	@PostMapping("/treatment")
	public @ResponseBody ClientMessage treatement(@RequestBody Patient patient) {
		return (nurseService.treatmentAndRelease(patient)) ? SUCCESSFULLY_TREATED : TREATMENT_FAILED;
	}
	
	@GetMapping("/getAllPatients")
	public @ResponseBody List<Patient> getAllPatients() {
		return nurseService.getAllPatients();
	}
	
	@PostMapping("/getMyPatients")
	public @ResponseBody List<Patient> getNursePatients(@RequestBody Employee nurse) {
		return nurseService.getNursePatients(nurse.getEmployeeId());
	}
	
	@GetMapping("/getAllMedicine")
	public @ResponseBody List<Medicine> getAllMeds() {
		return nurseService.getAllMedicines();
	}
	
	@PostMapping("/update")
	public @ResponseBody ClientMessage updateNurse(@RequestBody Employee nurse) {
		return (nurseService.update(nurse)) ? SUCCESSFUL_UPDATE : FAILED_UPDATE;
	}
	
	// TODO implement login function here.

}
