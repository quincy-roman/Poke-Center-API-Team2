package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.service.AdminService;
import com.revature.util.ClientMessage;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/updateUser")
	public <T> ResponseEntity<ClientMessage> updateUser(@RequestBody T user) {
		ClientMessage body = (adminService.updateUser(user)) ? SUCCESSFUL_UPDATE : FAILED_UPDATE;
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/getAllMeds")
	public ResponseEntity<List<Medicine>> getAllMedicines() {
		List<Medicine> medicines = adminService.getAllMedicines();
		return ResponseEntity.ok(medicines);
	}
	
	@PostMapping("/order")
	public ResponseEntity<ClientMessage> orderMeds(HashMap<Medicine, Integer> orderList) {
		ClientMessage body = (adminService.orderMeds(orderList)) ? ORDER_PLACED : ORDER_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/viewEmployees")
	public ResponseEntity<List<Employee>> viewEmployees() {
		List<Employee> employees = adminService.viewEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/viewTrainers")
	public ResponseEntity<List<Trainer>> viewTrainers() {
		List<Trainer> trainers = adminService.viewTrainers();
		return ResponseEntity.ok(trainers);
	}
	
	@PostMapping("/assignNurse")
	public ResponseEntity<ClientMessage> assignNurse(Patient patient, Employee nurse) {
		ClientMessage body = (adminService.assignNurse(patient, nurse)) ? NURSE_ASSIGNED : NURSE_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@DeleteMapping("/delete/{id}")
	public <T> ResponseEntity<ClientMessage> removeUser(T user) {
		ClientMessage body = (adminService.removeUser(user)) ? USER_REMOVED : USER_FAILED;
		return ResponseEntity.ok(body);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ClientMessage> loginEmpl(String username, String password) {
		ClientMessage body = (adminService.loginEmpl(username, password)) ? USER_LOGIN : LOGIN_FAILED;
		return ResponseEntity.ok(body);
	}

}
