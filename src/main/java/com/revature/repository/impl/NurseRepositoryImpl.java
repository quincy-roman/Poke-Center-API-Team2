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
public class NurseRepositoryImpl implements NurseRepository {

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
		crit.add(Restrictions.ge("stock", 1));
		List<Medicine> medicine = crit.list();
		return medicine;
	}

	@Override
	public void treatmentAndRelease(Patient patient) {
		sf.getCurrentSession().evict(patient);

		patient.setRelease(new Timestamp(System.currentTimeMillis()));
		patient.setStatus(null);

		sf.getCurrentSession().update(patient);

		medStock(patient.getMed());
	}

	public void medStock(Medicine medicine) {
		medicine.setStock(medicine.getStock() - 1);
		sf.getCurrentSession().update(medicine);
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
		crit = sf.getCurrentSession().createCriteria(Patient.class);
		crit.add(Restrictions.eq("nurseid", nurse_id));
		List<Patient> p = crit.list();
		return p;
	}

	@Override
	public void update(Employee nurse) {
		sf.getCurrentSession().update(nurse);
	}
}