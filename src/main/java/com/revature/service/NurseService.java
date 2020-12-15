package com.revature.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.repository.NurseRepository;

@Service("NurseService")
public class NurseService implements EmplService{
	
//	private static Logger log = Logger.getLogger(NurseService.class);

	@Autowired
	private NurseRepository nurseRepo;
	
	public boolean treatmentAndRelease(Patient patient) {	//TODO add medicine update.
		
		// Set the release time to now.
		patient.setRelease(new Timestamp(System.currentTimeMillis()));
		
		nurseRepo.treatmentAndRelease(patient);
		
		// Check to make sure the update was a success.
		return patient.getRelease() != null;
	}
	
	// Get all patients.
	public List<Patient> getAllPatients(){
		return nurseRepo.findAllPatients();
	}
	
	// Get patients for the logged in nurse.
	public List<Patient> getNursePatients(Employee nurse_id){
		return nurseRepo.findPatients(nurse_id);
	}
	
	@Override // Get all medicines.
	public List<Medicine> getAllMedicines(){
		return nurseRepo.getAllMedicines();
	}
	
	// Update the nurse's information.
	public boolean update(Employee nurse) {
		String username = nurse.getUsername();
		nurseRepo.update(nurse);
		//TODO This condition could be improved.
		return nurse.getUsername() != username;
	}
	
	@Override
	public boolean loginEmpl(String username, String password) {
		return nurseRepo.loginEmpl(username, password);
	}

}
