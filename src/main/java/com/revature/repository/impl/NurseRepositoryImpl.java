package com.revature.repository.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAllPatients() {
		return sf.getCurrentSession().createCriteria(Patient.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> getAllMedicines() {
		return sf.getCurrentSession().createCriteria(Medicine.class).list();
	}

	@Override
	public void update(Employee nurse) {
		sf.getCurrentSession().update(nurse);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findPatients(Employee nurse_id) {
		Criteria crit = sf.getCurrentSession().createCriteria(Patient.class);
		crit.add(Restrictions.eq("nurseid", nurse_id));
		List<Patient> p = crit.list();
		return p;
//		try {	// TODO Shouldn't be using casting here.
//			return (List<Patient>) sf.getCurrentSession().createCriteria(Patient.class)
//							.add(Restrictions.like("nurseid", nurse_id))
//							.list()
//							.get(0);
//		}catch(IndexOutOfBoundsException e) {
//			log.debug(e);
//			return null;
//		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean loginEmpl(String username, String password) {
		try {
			Criteria crit = sf.getCurrentSession().createCriteria(Employee.class);
			crit.add(Restrictions.ilike("username", username, MatchMode.EXACT))
				.add(Restrictions.like("password", password, MatchMode.EXACT));

			List<Employee> empl = crit.list();
			System.out.println(empl);

			if (empl.get(0) != null) {
				return true;
			}
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("FAIL 3");
			return false;
		} catch (QueryException e) {
			System.out.println("FAIL 4");
			return false;
		}
		return false;
	}


}
