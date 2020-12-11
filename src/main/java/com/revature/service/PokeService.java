package com.revature.service;

import com.revature.model.Employee;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.Trainer;

public interface PokeService {
	
	public boolean registerPokemon(Pokemon pokemon);

	public boolean registerTrainer(Trainer trainer);
	
	public void registerRole(Role nurse);

	public boolean loginTrainer(String username, String password);

	public void registerEmpl(Employee n);

	public boolean loginEmpl(String username, String password);

}
