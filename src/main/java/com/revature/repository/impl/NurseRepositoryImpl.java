package com.revature.repository.impl;

import java.sql.Timestamp;
import java.util.List;

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
import com.revature.model.StatusCondition;
import com.revature.repository.NurseRepository;

@Repository("nurseRepo")
@Transactional
public class NurseRepositoryImpl implements NurseRepository{

//	private static Logger log = Logger.getLogger(NurseRepositoryImpl.class);

	@Autowired
	private SessionFactory sf;
	
	Criteria crit;
	
	@SuppressWarnings("unchecked")
	public Patient findPatient(int patient) {
		 crit = sf.getCurrentSession().createCriteria(Patient.class);
		crit.add(Restrictions.idEq(patient));
		List<Patient> p = crit.list();
		return p.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Medicine treatment(StatusCondition status) {
		crit = sf.getCurrentSession().createCriteria(Medicine.class);
		crit.add(Restrictions.eq("status", status));
		List<Medicine> medicine = crit.list();
		return medicine.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public StatusCondition problem(String string) {
		crit = sf.getCurrentSession().createCriteria(StatusCondition.class);
		crit.add(Restrictions.like("statusName", string));
		List<StatusCondition> status = crit.list();
		return status.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> selectTreatment(StatusCondition status) {
		crit = sf.getCurrentSession().createCriteria(Medicine.class);
		crit.add(Restrictions.eq("status", status));
		List<Medicine> medicine = crit.list();
		return medicine;
	}

	@Override
	public void treatmentAndRelease(Patient patient) {
		sf.getCurrentSession().evict(patient);
		
		patient.setRelease(new Timestamp(System.currentTimeMillis()));
		patient.setStatus(null);

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findPatients(Employee nurse_id) {
		Criteria crit = sf.getCurrentSession().createCriteria(Patient.class);
		crit.add(Restrictions.eq("nurseid", nurse_id));
		List<Patient> p = crit.list();
		return p;
	}
	
	@Override
	public void update(Employee nurse) {
		sf.getCurrentSession().update(nurse);		
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