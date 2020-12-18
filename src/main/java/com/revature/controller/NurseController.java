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

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.StatusCondition;
import com.revature.model.dto.MedicineDTO;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.TreatmentWrapper;
import com.revature.service.NurseService;
import com.revature.service.PokeService;
import com.revature.util.ClientMessage;

@RestController
@RequestMapping(path = "/nurse", consumes = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "http://localhost:4200")
public class NurseController implements EmployeeController {

	@Autowired
	private NurseService nurseService;
	
	@Autowired
	private PokeService pokeService;	// for registration functionality.

	@PostMapping(path = "/table/get-poketreatment-by-patient-id", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<MedicineDTO>> selectmeds(@RequestBody StatusCondition status) {
		List<MedicineDTO> medicine = nurseService.selectTreatment(status);
		return ResponseEntity.ok(medicine);
	}

	@PutMapping(path = "/update/my-pokepatient-charts", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> applymeds(@RequestBody TreatmentWrapper t){
		
		
		System.out.println(t.getPatientid());
		
		Patient p = nurseService.findPatient(t.getPatientid());
		Medicine m = nurseService.getMed(t.getMedid());
		System.out.println("\n"+p+ "\n");
		ClientMessage body = (nurseService.applytreatment(p, m)) ? SUCCESSFULLY_TREATED
				: TREATMENT_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@PutMapping(path = "/treatment/authorize-discharge", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> declarehealthy(@RequestBody int patientId){
		Patient p = nurseService.findPatient(patientId);
		ClientMessage body = (nurseService.declarehealthy(p)) ? SUCCESSFULLY_TREATED
				: TREATMENT_FAILED;
		return ResponseEntity.ok(body);
	}

	@PostMapping(path = "/table/view-my-pokepatients", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<PatientDTO>> getNursePatients(@RequestBody Employee nurse) {
		List<PatientDTO> nursesPatients = nurseService.getNursePatients(nurse);
		return ResponseEntity.ok(nursesPatients);
	}

	@PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> updateNurse(@RequestBody Employee nurse) {
		ClientMessage body = (nurseService.update(nurse)) ? SUCCESSFUL_UPDATE : FAILED_UPDATE;
		return ResponseEntity.ok(body);
	}

	@Override
	@GetMapping("/nurse/medicine")
	public ResponseEntity<List<MedicineDTO>> getAllMedicines() {
		List<MedicineDTO> medicines = nurseService.getAllMedicines();
		return ResponseEntity.ok(medicines);
	}

	@Override
	@GetMapping("/table/view-all-admitted-pokepatients")
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		List<PatientDTO> patients = nurseService.getAllPatients();
		return ResponseEntity.ok(patients);
	}

	@Override
	@PostMapping(path = "/registration", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> register(@RequestBody Employee emp) {
		ClientMessage body = (pokeService.registerEmpl(emp)) ? USER_REGISTERED : USER_NOT_REGISTERED;
		return ResponseEntity.ok(body);
	}
	
}
