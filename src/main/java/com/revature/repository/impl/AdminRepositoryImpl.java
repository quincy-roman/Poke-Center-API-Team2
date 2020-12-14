package com.revature.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Trainer;
import com.revature.repository.AdminRepository;

@Repository("adminRepo")
@Transactional
public class AdminRepositoryImpl implements AdminRepository {

	private static Logger log = Logger.getLogger(NurseRepositoryImpl.class);

	@Autowired
	private SessionFactory sf;
	
	@Override
	public <T> void update(T user) {
		sf.getCurrentSession().update(user);
	}

	@Override
	public List<Medicine> getAllMedicines() {
		return sf.getCurrentSession().createCriteria(Medicine.class).list();
	}

	@Override
	public void orderMeds(HashMap<Medicine, Integer> orderList) {
		for(Map.Entry<Medicine, Integer> med : orderList.entrySet()) {
			
			// Increase the stock by the passed integer.
			med.getKey().setStock(med.getKey().getStock() + med.getValue());
			
			// Update that medicine (the key).
			sf.getCurrentSession().update(med.getKey());
		}
	}

	@Override
	public List<Employee> viewEmployees() {
		return sf.getCurrentSession().createCriteria(Employee.class).list();
	}

	@Override
	public List<Trainer> viewTrainers() {
		return sf.getCurrentSession().createCriteria(Trainer.class).list();
	}

	@Override
	public <T> void remove(T user) {
		sf.getCurrentSession().delete(user);
	}

}
