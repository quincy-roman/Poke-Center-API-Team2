package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Pokemon;
import com.revature.repository.PokeRepo;

@Service("PokeService")
public class PokeServiceImpl implements PokeService {
	
	private static Logger log = Logger.getLogger(PokeServiceImpl.class);

	@Autowired
	private PokeRepo pokeRepo;
	
	public PokeServiceImpl() {
		System.out.println("WORKED 1");
	}

	@Override
	public boolean registerPokemon(Pokemon pokemon) {
		pokeRepo.save(pokemon);
		return pokemon.getDexid() != 0;
	}
}