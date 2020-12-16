package com.revature.service;

import java.util.List;

import com.revature.model.Medicine;
import com.revature.model.Patient;

public interface EmplService {

	public List<Medicine> getAllMedicines();
	
	public List<Patient> getAllPatients();
}
