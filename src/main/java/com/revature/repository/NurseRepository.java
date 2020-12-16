package com.revature.repository;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.StatusCondition;

public interface NurseRepository {

	// Update the patient's status, health, and release time.
	void treatmentAndRelease(Patient patient);

	// Retrieve all records, current and past.
	List<Patient> findAllPatients();

	// Get all medicines and return in a list for calculations.
	List<Medicine> getAllMedicines(); // TODO this could be an enum instead (unchanging list).

	// Update the nurse's information.
	void update(Employee nurse);

	// Retrieve the nurse's patients.
	List<Patient> findPatients(Employee nurse_id);

	boolean loginEmpl(String username, String password);

	Patient findPatient(int patient);

	Medicine treatment(StatusCondition s);

	StatusCondition problem(String string);

	List<Medicine> selectTreatment(StatusCondition s);
}
