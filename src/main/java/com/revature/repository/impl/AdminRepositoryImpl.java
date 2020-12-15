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

//	private static Logger log = Logger.getLogger(NurseRepositoryImpl.class);

	@Autowired
	private SessionFactory sf;

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

	@Override
	public <T> void remove(T user) {
		sf.getCurrentSession().delete(user);
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

	public void assignNurse(Patient patient) {
		sf.getCurrentSession().update(patient);
	}

}
