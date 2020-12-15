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
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;
import com.revature.repository.PokeRepo;

@Repository("pokeRepo")
@Transactional
public class PokeRepoImpl implements PokeRepo {

	private static Logger log = Logger.getLogger(PokeRepoImpl.class);

	@Autowired
	private SessionFactory sf;

	public PokeRepoImpl() {
		System.out.println("WORKED 2");
	}

	@Override
	public void save(Pokemon pokemon) {
		sf.getCurrentSession().save(pokemon);
	}
	
	@Override
	public void save(StatusCondition statusCondition) {
		sf.getCurrentSession().save(statusCondition);
	}


	@Override
	public void save(Trainer trainer) {
		sf.getCurrentSession().save(trainer);
	}

	@Override
	public void save(Role role) {
		sf.getCurrentSession().save(role);
	}
	
	@Override
	public void save(Employee empl) {
		sf.getCurrentSession().save(empl);
	}
	
	@Override
	public void save(Medicine med) {
		sf.getCurrentSession().save(med);
	}

	@Override
	public void save(Patient patient) {
		sf.getCurrentSession().save(patient);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean loginTrainer(String username, String password) {
		try {
			Criteria crit = sf.getCurrentSession().createCriteria(Trainer.class);
			crit.add(Restrictions.ilike("username", username, MatchMode.EXACT))
				.add(Restrictions.like("password", password, MatchMode.EXACT));

			List<Trainer> trainer = crit.list();
			System.out.println(trainer);
			
			if (trainer.get(0) != null) {
				return true;
			}
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("FAIL 1");
			return false;
		} catch (QueryException e) {
			System.out.println("FAIL 3");
			return false;
		}
		return false;
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
