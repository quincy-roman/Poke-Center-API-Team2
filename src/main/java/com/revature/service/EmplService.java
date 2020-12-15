package com.revature.service;

import java.util.List;

import com.revature.model.Medicine;

public interface EmplService {

	public List<Medicine> getAllMedicines();
	
	public boolean loginEmpl(String username, String password);

}
