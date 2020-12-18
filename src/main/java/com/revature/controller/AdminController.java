package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.dto.EmployeeDTO;
import com.revature.model.dto.MedicineDTO;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.PatientWrapper;
import com.revature.model.dto.TrainerDTO;
import com.revature.service.AdminService;
import com.revature.service.NurseService;
import com.revature.service.PokeService;
import com.revature.util.ClientMessage;

@RestController
@RequestMapping(path = "/admin", consumes = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins="http://localhost:4200")
public class AdminController implements EmployeeController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PokeService pokeService;
	
	@Autowired
	private NurseService nurseService;

	@PutMapping(path = "/modify-user-info", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public <T> ResponseEntity<ClientMessage> updateUser(@RequestBody T user) {
		ClientMessage body = (adminService.updateUser(user)) ? SUCCESSFUL_UPDATE : FAILED_UPDATE;
		return ResponseEntity.ok(body);
	}

	@PostMapping(path = "/order-medication", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> orderMeds(@RequestBody HashMap<Medicine, Integer> orderList) {
		ClientMessage body = (adminService.orderMeds(orderList)) ? ORDER_PLACED : ORDER_FAILED;
		return ResponseEntity.ok(body);
	}

	@GetMapping("/table/view-employees")
	public ResponseEntity<List<EmployeeDTO>> viewEmployees() {
		List<EmployeeDTO> employees = adminService.viewEmployees();
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/table/view-trainers")
	public ResponseEntity<List<TrainerDTO>> viewTrainers() {
		List<TrainerDTO> trainers = adminService.viewTrainers();
		return ResponseEntity.ok(trainers);
	}

	@PutMapping(path = "/assign-nurse", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> assignNurse(@RequestBody PatientWrapper assignData) {
		ClientMessage body = (adminService.assignNurse(assignData.getPatientDTO().getPatientid(),
													   assignData.getNurseDTO().getUsername())) ? NURSE_ASSIGNED : NURSE_FAILED;
		return ResponseEntity.ok(body);
	}

	@DeleteMapping(path = "/remove-trainer", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> removeTrainer(@RequestBody int trainerid) {
		ClientMessage body = (adminService.removeTrainer(trainerid)) ? USER_REMOVED : USER_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@DeleteMapping(path = "/remove-employee", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> removeEmployee(@RequestBody int employeeid) {
		ClientMessage body = (adminService.removeEmployee(employeeid)) ? USER_REMOVED : USER_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@DeleteMapping(path = "/remove-record", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> removeRecord(@RequestBody int recordid) {
		ClientMessage body = (adminService.removeRecord(recordid)) ? RECORD_REMOVED : RECORD_FAILED; 
		return ResponseEntity.ok(body);
	}

	@Override
	@GetMapping("/table/view-current-med-stock")
	public ResponseEntity<List<MedicineDTO>> getAllMedicines() {	// View current medstock.
		List<MedicineDTO> medicines = adminService.getAllMedicines();
		return ResponseEntity.ok(medicines);
	}

	@Override
	@GetMapping("/table/view-patients")
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		List<PatientDTO> patients = adminService.getAllPatients();
		return ResponseEntity.ok(patients);
	}
	
	@PutMapping(path = "/patient/release", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> release(@RequestBody int patientid) {
		Patient patient = nurseService.findPatient(patientid);
		ClientMessage body = (adminService.release(patient)) ? SUCCESSFULLY_TREATED
				: TREATMENT_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@Override
	@PostMapping(path = "/registration", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> register(@RequestBody Employee emp) {
		ClientMessage body = (pokeService.registerEmpl(emp)) ? USER_REGISTERED : USER_NOT_REGISTERED;
		return ResponseEntity.ok(body);
	}

}
