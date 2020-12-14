package com.revature.repository.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Pokemon;
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

}
