package com.revature.service;

import com.revature.model.Pokemon;
import com.revature.model.Trainer;

public interface PokeService {
	
	public boolean registerPokemon(Pokemon pokemon);

	public boolean registerTrainer(Trainer trainer);
	
	public boolean login(String username, String password);

}
