package com.revature.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.repository.AdminRepository;

@Service("AdminService")
public class AdminService implements EmplService{
	
	//private static Logger log = Logger.getLogger(NurseService.class);

	@Autowired
	private AdminRepository adminRepo;
	
	// Update users.
	public <T> boolean updateUser(T user) {
		adminRepo.update(user);
		return true;	// TODO this is obviously bad.
	}
	
	// Retrieve a list of all medicines.
	public List<Medicine> getAllMedicines() {
		return adminRepo.getAllMedicines();
	}
	
	// Order medicines.
	public boolean orderMeds(HashMap<Medicine, Integer> orderList) {		
		//orderList.
		adminRepo.orderMeds(orderList);
		return true; // TODO fix this. 
	}
	
	// View all employees TODO switch this to the EmployeeDTO.
	public List<Employee> viewEmployees() {
		return adminRepo.viewEmployees();
	}
	
	// View all trainers TODO switch this to the TrainerDTO.
	public List<Trainer> viewTrainers() {
		return adminRepo.viewTrainers();
	}
	
	// Assign a nurse to a patient.
	public boolean assignNurse(Patient patient, Employee nurse) {
		patient.setNurseid(nurse);
		adminRepo.assignNurse(patient);
		return patient.getNurseid().getEmployeeId() != 0;
	}
	
	// Remove a user.
	public <T> boolean removeUser(T user) {
		adminRepo.remove(user);
		
		//I think this works.
		return user == null;
	}

	
	public boolean loginEmpl(String username, String password) {
		return adminRepo.loginEmpl(username, password);
	}
}
