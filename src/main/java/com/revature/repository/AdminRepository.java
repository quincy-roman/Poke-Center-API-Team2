package com.revature.repository;

import java.util.HashMap;
import java.util.List;

import com.revature.model.BillingHistory;
import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Trainer;

public interface AdminRepository {

	// Update a user.
	<T> void update(T user);

	// Get all medicines to view stock.
	List<Medicine> getAllMedicines();

	// Order medicine.
	void orderMeds(HashMap<Medicine, Integer> orderList);

	// View all employees.
	List<Employee> viewEmployees();

	// View all trainers.
	List<Trainer> viewTrainers();

	// View all patients.
	List<Patient> viewPatients();

	// Update a patient with a new nurse.
	void assignNurse(Patient patient);

	// Remove a user, utilizing generics here.
//	<T> void remove(T user);
	
	void remove(Employee e);
	
	void remove(Trainer t);
	
	void remove(Patient p);
	
	Employee getEmployee(int empid);

	Employee getNurse(String username);

	void release(Patient patient);

	BillingHistory save(BillingHistory b);
}
