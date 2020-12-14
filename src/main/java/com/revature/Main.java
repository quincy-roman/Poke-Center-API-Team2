package com.revature;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;
import com.revature.service.PokeService;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	static ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");

	static PokeService PokeService = ac.getBean("PokeService", PokeService.class);
	
	static Timestamp admission = new Timestamp(System.currentTimeMillis());

	public static void main(String[] args) {

		registerTrainer(); //and login WORKED
		System.out.println("REGISTERED TRAINER");
		registerEmpl(); //roles and login WORKED
		System.out.println("REGISTERED EMPL AND ROLES");
		registerStatus(); //and meds
		System.out.println("REGISTERED STATUS AND MEDS");
		registerPokemon();
		System.out.println("REGISTERED POKEDEX");
		registerPatient();	
	}

	private static void registerStatus() {
		PokeService.registerStatus(new StatusCondition(1, "Burn"));
		PokeService.registerStatus(new StatusCondition(3, "Fainted"));
		PokeService.registerStatus(new StatusCondition(2, "Sleep"));
		
		PokeService.registerMedicine(new Medicine("Burn Heal", 100.5, 20, new StatusCondition(1, "Burn")));
		PokeService.registerMedicine(new Medicine("Revive", 250, 10, new StatusCondition(3, "Fainted")));
		PokeService.registerMedicine(new Medicine("Awakening", 100, 5, new StatusCondition(2, "Sleep")));
	}

	private static void registerPokemon() {
		PokeService.registerPokemon(new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"));
		PokeService.registerPokemon(new Pokemon(15, "Beedrill", "Bug", "Poison", "Swarm"));
		PokeService.registerPokemon(new Pokemon(63, "Abra", "Psychic", null, "Inner Focus"));

	}

	private static void registerPatient() {
		PokeService.registerPatient(new Patient(
				new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"), 
				new Trainer(1, "Ash", "Pallet Town", "fire", "red"),
				admission, 300, 300, 
				new StatusCondition(2, "Sleep"),
				null, null, false, null));
	}

	public static void registerTrainer() {
		PokeService.registerTrainer(new Trainer(1, "Ash", "Pallet Town", "fire", "red"));
		
		PokeService.registerTrainer(new Trainer(4, "Lucas", "Littleroot Town", "Diamond", "pearl"));
		
		PokeService.registerTrainer(new Trainer(3, "Brendan", "Twin Leaf Town", "Sapphire", "ruby"));

//		if (PokeService.loginTrainer(t.getUsername(), t.getPassword())) {
//			System.out.println("logged into trainer");
//		} else {
//			System.out.println("FAIL 2");
//		}

	}

	public static void registerEmpl() {
		Role nurse = new Role(1, "Nurse");
		Role admin = new Role(2, "Admin");

		PokeService.registerRole(nurse);
		PokeService.registerRole(admin);

		PokeService.registerEmpl(new Employee(1, "Nurse1", "1", "1", nurse));
		PokeService.registerEmpl(new Employee(3, "Nurse3", "3", "3", nurse));
		PokeService.registerEmpl(new Employee(3, "Nurse3", "3", "3", nurse));

		PokeService.registerEmpl(new Employee(4, "Admin4", "4", "4", admin));
		PokeService.registerEmpl(new Employee(2, "Admin2", "2", "2", admin));
		PokeService.registerEmpl(new Employee(6, "Admin6", "6", "6", admin));

//		if (PokeService.loginEmpl(a.getUsername(), a.getPassword())) {
//			if (a.getRole() == nurse) {
//				System.out.println("nurse homepage");
//			} else if (a.getRole() == admin) {
//				System.out.println("admin homepage");
//			} else {
//				System.out.println("Fail 2");
//			}
//		} else {
//			System.out.println("Fail 1");
//		}

	}

}
