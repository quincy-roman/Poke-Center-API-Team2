package com.revature.service;

import java.util.List;

import com.revature.model.dto.MedicineDTO;
import com.revature.model.dto.PatientDTO;

public interface EmplService {

	public List<MedicineDTO> getAllMedicines();
	
	public List<PatientDTO> getAllPatients();
}
