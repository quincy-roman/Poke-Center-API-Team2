package com.revature.repository.impl;

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
import com.revature.model.Trainer;
import com.revature.repository.LoginRepository;

@Repository("loginRepo")
@Transactional
public class LoginRepositoryImpl implements LoginRepository{
	
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public Employee loginEmployee(String username, String password) {
		try {
			Criteria crit = sf.getCurrentSession().createCriteria(Employee.class);
			crit.add(Restrictions.ilike("username", username, MatchMode.EXACT))
					.add(Restrictions.like("password", password, MatchMode.EXACT));

			List<Employee> empl = crit.list();
			System.out.println(empl);

			if (empl.get(0) != null) {
				return empl.get(0);
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("FAIL 3");
			return null;
		} catch (QueryException e) {
			System.out.println("FAIL 4");
			return null;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Trainer loginTrainer(String username, String password) {
		try {
			Criteria crit = sf.getCurrentSession().createCriteria(Trainer.class);
			crit.add(Restrictions.ilike("username", username, MatchMode.EXACT))
				.add(Restrictions.like("password", password, MatchMode.EXACT));

			List<Trainer> trainer = crit.list();
			System.out.println(trainer);

			if (trainer.get(0) != null) {
				return trainer.get(0);
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("FAIL 1");
			return null;
		} catch (QueryException e) {
			System.out.println("FAIL 3");
			return null;
		}
		return null;
	}

}
