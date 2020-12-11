package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Pokemon;
import com.revature.model.Trainer;
import com.revature.repo.PokeRepo;

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

	@Override
	public boolean registerTrainer(Trainer trainer) {
		pokeRepo.save(trainer);
		return trainer.getTrainerId() != 0;
	}

	@Override
	public boolean login(String username, String password) {
		return pokeRepo.login(username, password);
	}
}