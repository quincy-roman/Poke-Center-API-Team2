package com.revature.repo;

import com.revature.model.Pokemon;
import com.revature.model.Trainer;

public interface PokeRepo {

	void save(Pokemon pokemon);

	void save(Trainer trainer);

	boolean login(String username, String password);
}
