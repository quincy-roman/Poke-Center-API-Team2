package com.revature.repository.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.repository.NurseRepository;

@Repository("nurseRepo")
@Transactional
public class NurseRepositoryImpl implements NurseRepository{

	private static Logger log = Logger.getLogger(NurseRepositoryImpl.class);

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void treatmentAndRelease(Patient patient) {
		sf.getCurrentSession().update(patient);	// TODO Might want to set a trigger to lower med count.
		// Or we can update the med count directly in this same method.
	}

	@Override
	public List<Patient> findAllPatients() {
		return sf.getCurrentSession().createCriteria(Patient.class).list();
	}

	@Override
	public List<Medicine> getAllMedicines() {
		return sf.getCurrentSession().createCriteria(Medicine.class).list();
	}

	@Override
	public void update(Employee nurse) {
		sf.getCurrentSession().update(nurse);		
	}

	@Override
	public List<Patient> findPatients(int nurse_id) {
		try {	// TODO Shouldn't be using casting here.
			return (List<Patient>) sf.getCurrentSession().createCriteria(Patient.class)
							.add(Restrictions.like("nurseid", nurse_id))
							.list()
							.get(0);
		}catch(IndexOutOfBoundsException e) {
			log.debug(e);
			return null;
		}
	}

}
