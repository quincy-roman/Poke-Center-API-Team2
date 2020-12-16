package com.revature.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.revature.model.Trainer;
import com.revature.repository.AdminRepository;

@Repository("adminRepo")
@Transactional
public class AdminRepositoryImpl implements AdminRepository {

//	private static Logger log = Logger.getLogger(AdminRepositoryImpl.class);

	@Autowired
	private SessionFactory sf;

	Criteria crit;

	@Override
	public <T> void update(T user) {
		sf.getCurrentSession().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> getAllMedicines() {
		return sf.getCurrentSession().createCriteria(Medicine.class).list();
	}

	@Override
	public void orderMeds(HashMap<Medicine, Integer> orderList) {
		for (Map.Entry<Medicine, Integer> med : orderList.entrySet()) {

			// Increase the stock by the passed integer.
			med.getKey().setStock(med.getKey().getStock() + med.getValue());

			// Update that medicine (the key).
			sf.getCurrentSession().update(med.getKey());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> viewEmployees() {
		return sf.getCurrentSession().createCriteria(Employee.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trainer> viewTrainers() {
		return sf.getCurrentSession().createCriteria(Trainer.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> viewPatients() {
		return sf.getCurrentSession().createCriteria(Patient.class).list();
	}

	@Override
	public <T> void remove(T user) {
		sf.getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee getNurse(String username) {
		crit = sf.getCurrentSession().createCriteria(Employee.class);
		crit.add(Restrictions.ilike("username", username, MatchMode.EXACT));
		
		List<Employee> nurse = crit.list();
		
		return nurse.get(0);
	}

	@Override
	public void assignNurse(Patient patient) {
		sf.getCurrentSession().update(patient);
	}

}
