package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.StatusCondition;
import com.revature.repository.NurseRepository;

@Service("NurseService")
public class NurseService implements EmplService {

//	private static Logger log = Logger.getLogger(NurseService.class);

	@Autowired
	private NurseRepository nurseRepo;

	public Patient findPatient(int patient) {
		return nurseRepo.findPatient(patient);
	}

	public boolean treatmentAndRelease(Patient patient, Medicine m, boolean b) { // TODO add medicine update.

		// Set the release time to now.

		patient.setMed(m);
		patient.setHealthy(b);

		nurseRepo.treatmentAndRelease(patient);

		// Check to make sure the update was a success.
		return patient.getRelease() != null;
	}


	// Get patients for the logged in nurse.
	public List<Patient> getNursePatients(Employee nurse_id) {
		return nurseRepo.findPatients(nurse_id);
	}

	@Override // Get all medicines.
	public List<Medicine> getAllMedicines() {
		return nurseRepo.getAllMedicines();
	}

	// Update the nurse's information.
	public boolean update(Employee nurse) {
		String username = nurse.getUsername(); //Not relevant to code working
		nurseRepo.update(nurse);
		// TODO This condition could be improved.
		return nurse.getUsername() != username;
	}

	public Medicine treatment(StatusCondition s) {
		return nurseRepo.treatment(s);
	}

	public List<Medicine> selectTreatment(StatusCondition s) {
		return nurseRepo.selectTreatment(s);
	}

	public StatusCondition problem(String string) {
		return nurseRepo.problem(string);
	}

	@Override
	// Get all patients.
	public List<Patient> getAllPatients() {
		return nurseRepo.findAllPatients();
	}

}
