package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.StatusCondition;
import com.revature.model.dto.MedicineDTO;
import com.revature.model.dto.PatientDTO;
import com.revature.repository.NurseRepository;

@Service("NurseService")
public class NurseService implements EmplService {

//	private static Logger log = Logger.getLogger(NurseService.class);

	@Autowired
	private NurseRepository nurseRepo;

	public Patient findPatient(int patient) {
		return nurseRepo.findPatient(patient);
	}

	// Get patients for the logged in nurse.
	public List<PatientDTO> getNursePatients(Employee nurse) {
		List<Patient> patients = nurseRepo.findPatients(nurse);
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

	@Override // Get all medicines.
	public List<MedicineDTO> getAllMedicines() {
		List<Medicine> meds = nurseRepo.getAllMedicines();
		List<MedicineDTO> medsDTO = new ArrayList<>();
		for (Medicine m : meds) {
			MedicineDTO mdto = new MedicineDTO(m.getMedID(), m.getMedName(), m.getCost(), m.getStock());
			medsDTO.add(mdto);
		}

		return medsDTO;
	}

	// Update the nurse's information.
	public boolean update(Employee nurse) {
		String username = nurse.getUsername(); // Not relevant to code working
		nurseRepo.update(nurse);
		// TODO This condition could be improved.
		return nurse.getUsername() != username;
	}

	public Medicine treatment(StatusCondition s) {
		return nurseRepo.treatment(s);
	}

	public List<MedicineDTO> selectTreatment(StatusCondition s) {
		List<Medicine> meds = nurseRepo.selectTreatment(s);
		List<MedicineDTO> medsDTO = new ArrayList<>();
		for (Medicine m : meds) {
			MedicineDTO mdto = new MedicineDTO(m.getMedID(), m.getMedName(), m.getCost(), m.getStock());
			medsDTO.add(mdto);
		}

		return medsDTO;
	}

	public StatusCondition problem(String string) {
		return nurseRepo.problem(string);
	}

	@Override
	// Get all patients.
	public List<PatientDTO> getAllPatients() {
		List<Patient> patients = nurseRepo.findAllPatients();
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

	public boolean applytreatment(Patient patient, Medicine med) {
		if (patient.getStatus().getStatusId() == med.getStatus().getStatusId()) {
			
			patient.setStatus(med.getStatus());
			patient = nurseRepo.treat(patient, med);

			if (patient.getMed() != null) {
				nurseRepo.medStock(patient.getMed());
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean declarehealthy(Patient p) {
		nurseRepo.declarehealthy(p);

		if (p.isHealthy()) {
			return true;
		} else {
			return false;
		}
	}

	public Medicine getMed(int med) {
		return nurseRepo.getMed(med);
	}

}
