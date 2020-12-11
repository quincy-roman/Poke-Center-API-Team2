package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Employee;
import com.revature.model.Role;
import com.revature.model.Trainer;
import com.revature.service.PokeService;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	static ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");

	static PokeService PokeService = ac.getBean("PokeService", PokeService.class);

	public static void main(String[] args) {

		// registerTrainer(); //and login WORKED

		//registerEmpl(); //roles and login WORKED

		// PokeService.registerPokemon(new Pokemon(3, "Venasuar", "Grass", "Poison",
		// "Overgrow"));

	}

	public static void registerTrainer() {
		Trainer t = new Trainer(1, "Ash", "Pallet Town", "fire", "red");

		PokeService.registerTrainer(t);

		if (PokeService.loginTrainer(t.getUsername(), t.getPassword())) {
			System.out.println("logged into trainer");
		} else {
			System.out.println("FAIL 2");
		}

	}

	public static void registerEmpl() {
		Role nurse = new Role(1, "Nurse");
		Role admin = new Role(2, "Admin");

//		PokeService.registerRole(nurse);
//		PokeService.registerRole(admin);

		Employee n = new Employee(1, "Nurse", "1", "2", nurse);
		Employee a = new Employee(2, "Admin", "3", "4", admin);

//		PokeService.registerEmpl(n);
//		PokeService.registerEmpl(a);

		if (PokeService.loginEmpl(a.getUsername(), a.getPassword())) {
			if (a.getRole() == nurse) {
				System.out.println("nurse homepage");
			} else if (a.getRole() == admin) {
				System.out.println("admin homepage");
			} else {
				System.out.println("Fail 2");
			}
		} else {
			System.out.println("Fail 1");
		}

	}

}
