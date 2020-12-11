package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Trainer;
import com.revature.service.PokeService;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	static ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
	
	static PokeService PokeService = ac.getBean("PokeService", PokeService.class);

	public static void main(String[] args) {
		
		registerTrainer();
		//PokeService.registerPokemon(new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"));
		
	}
	
	public static void registerTrainer() {
		Trainer t = new Trainer(1, "Ash", "Pallet Town", "fire", "red");
		
		PokeService.registerTrainer(t);
		
		if(PokeService.login(t.getUsername(), t.getPassword())) {
			System.out.println("logged into trainer");
		}else {
			System.out.println("FAIL 2");
		}

	}

}
