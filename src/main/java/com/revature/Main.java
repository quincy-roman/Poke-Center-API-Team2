package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Pokemon;
import com.revature.service.PokeService;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
		
		PokeService PokeService = ac.getBean("PokeService", PokeService.class);
		
		PokeService.registerPokemon(new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"));
	}

}
