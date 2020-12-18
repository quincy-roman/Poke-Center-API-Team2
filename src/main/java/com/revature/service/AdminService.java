package com.revature.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.BillingHistory;
import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Trainer;
import com.revature.model.dto.EmployeeDTO;
import com.revature.model.dto.MedicineDTO;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.TrainerDTO;
import com.revature.repository.AdminRepository;
import com.revature.repository.NurseRepository;
import com.revature.repository.TrainerRepo;

@Service("AdminService")
public class AdminService implements EmplService {

	// private static Logger log = Logger.getLogger(AdminService.class);

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private NurseRepository nurseRepo;
	
	@Autowired
	private TrainerRepo trainerRepo;

	// Update users.
	public <T> boolean updateUser(T user) {
		adminRepo.update(user);
		return true; // TODO this is obviously bad.
	}

	// Order medicines.
	public boolean orderMeds(HashMap<Medicine, Integer> orderList) {
		// orderList.
		adminRepo.orderMeds(orderList);
		return true; // TODO fix this.
	}

	// View all employees
	public List<EmployeeDTO> viewEmployees() {
		List<Employee> emps = adminRepo.viewEmployees();
		List<EmployeeDTO> empDTO = new ArrayList<>();
		for(Employee e : emps) {
			EmployeeDTO edto = new EmployeeDTO(e.getEmployeeId(), 
											   e.getUsername(), 
											   e.getPassword(), 
											   e.getEmployeeName(), 
											   e.getRole().getRoleid());
			empDTO.add(edto);
		}
		return empDTO;
	}

	// View all trainers 
	public List<TrainerDTO> viewTrainers() {
		List<Trainer> trainers = adminRepo.viewTrainers();
		List<TrainerDTO> trainerDTOs = new ArrayList<>();
		for(Trainer t : trainers) {
			TrainerDTO tdto = new TrainerDTO(t.getTrainerId(), 
											 t.getTrainerName(), 
											 t.getHometown(), 
											 t.getUsername(), 
											 t.getPassword());
			trainerDTOs.add(tdto);
		}
		return trainerDTOs;
	}


	// Assign a nurse to a patient.
	public boolean assignNurse(int patientid, String username) {
		Patient patient = nurseRepo.findPatient(patientid);
		Employee nurse = adminRepo.getNurse(username);
		
		patient.setNurseid(nurse);	//This sets the entire object.
		
		// Update the patient with their newly assigned nurse.
		adminRepo.assignNurse(patient);
		
		return patient.getNurseid().getEmployeeId() != 0;
	}

//	// Remove a user.
//	public <T> boolean removeUser(T user) {
//		adminRepo.remove(user);
//
//		return user == null;
//	}
	
	public boolean removeRecord(int patientid) {
		Patient patient = nurseRepo.findPatient(patientid);
		
		adminRepo.remove(patient);
		
		return patient == null;
	}
	
	public boolean removeEmployee(int employeeid) {
		Employee employee = adminRepo.getEmployee(employeeid);
		
		adminRepo.remove(employee);
		
		return employee == null;
	}
	
	public boolean removeTrainer(int trainerid) {
		Trainer trainer = trainerRepo.getTrainerId(trainerid);
		
		adminRepo.remove(trainer);
		
		return trainer == null;
	}

	@Override
	// Retrieve a list of all medicines.
	public List<MedicineDTO> getAllMedicines() {
		List<Medicine> meds = adminRepo.getAllMedicines();
		List<MedicineDTO> medsDTO = new ArrayList<>();
		for(Medicine m : meds) {
			MedicineDTO mdto = new MedicineDTO(m.getMedID(), m.getMedName(), m.getCost(), m.getStock());
			medsDTO.add(mdto);
		}
		
		return medsDTO;
	}
	
	@Override
	// Return a List of all patients.
	public List<PatientDTO> getAllPatients() {
		List<Patient> patients = adminRepo.viewPatients();
		List<PatientDTO> patientDTOs = new ArrayList<>();
		for(Patient p : patients) {
			PatientDTO pdto = new PatientDTO(p.getPateintid(), p.getPokemon().getDexid(), 
											 p.getTrainer().getTrainerId(), p.getAdmission(), 
											 p.getRelease(), p.getCurrentHP(), p.getMaxHP(), 
											 p.getStatus().getStatusId(), 0, 
											 p.isHealthy());
			if(p.getMed() != null) {
				pdto.setMedId(p.getMed().getMedID());
			}
			patientDTOs.add(pdto);
		}
		return patientDTOs;
	}

	public Employee getNurse(String username) {
		return adminRepo.getNurse(username);
	}

	public boolean release(Patient patient) {
		adminRepo.release(patient);

		// Check to make sure the update was a success.
		return patient.getRelease() != null;
	}

	public BillingHistory registerBill(BillingHistory b) {
		return adminRepo.save(b);
	}	
}