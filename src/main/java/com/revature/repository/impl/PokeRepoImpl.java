package com.revature.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.repository.PokeRepo;

@Repository("pokeRepo")
@Transactional
public class PokeRepoImpl implements PokeRepo {

//	private static Logger log = Logger.getLogger(PokeRepoImpl.class);

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

}
