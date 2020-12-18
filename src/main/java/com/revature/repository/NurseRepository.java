package com.revature.repository;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.StatusCondition;

public interface NurseRepository {

	// Retrieve all records, current and past.
	List<Patient> findAllPatients();

	// Get all medicines and return in a list for calculations.
	List<Medicine> getAllMedicines(); // TODO this could be an enum instead (unchanging list).

	// Update the nurse's information.
	void update(Employee nurse);

	// Retrieve the nurse's patients.
	List<Patient> findPatients(Employee nurse_id);

	Patient findPatient(int patient);

	Medicine treatment(StatusCondition s);

	StatusCondition problem(String string);

	List<Medicine> selectTreatment(StatusCondition s);

	Patient treat(Patient patient, Medicine med);

	void declarehealthy(Patient p);

	void medStock(Medicine med);

	Medicine getMed(int med);

}
