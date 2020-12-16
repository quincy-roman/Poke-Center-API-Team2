package com.revature;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.BillingHistory;
import com.revature.model.Employee;
import com.revature.model.Medicine;
import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;
import com.revature.service.AdminService;
import com.revature.service.NurseService;
import com.revature.service.PokeService;
import com.revature.service.TrainerService;

public class Main {
//	private static Logger log = Logger.getLogger(Main.class);

	static ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");

	static PokeService PokeService = ac.getBean("PokeService", PokeService.class);

	static TrainerService TrainerService = ac.getBean("TrainerService", TrainerService.class);

	static NurseService NurseService = ac.getBean("NurseService", NurseService.class);
	
	static AdminService AdminService = ac.getBean("AdminService", AdminService.class);

	static Timestamp admission = new Timestamp(System.currentTimeMillis());

	public static void main(String[] args) {		
		register();
//		
//		get();
//		
//		functions();		
	}

	@SuppressWarnings("unused")
	private static void functions() {
		updateProfile(); //WORKED	
		
		assignnurse(); //WORKED
		
		getMeds(); //WORKED

		treatment();
		
		declarehealthy();
		
		releasePatient(); //WORKED

	}

	private static void declarehealthy() {
		Patient p = NurseService.findPatient(14);
		NurseService.declarehealthy(p);
		
	}

	private static void treatment() {
		Patient p = NurseService.findPatient(14);
		StatusCondition s = NurseService.problem("Sleep");
		Medicine m = NurseService.treatment(s);
		NurseService.applytreatment(p, m);
	}

	private static void assignnurse() {
		Patient patient = NurseService.findPatient(13);
		Employee nurse = AdminService.getNurse("1");
		AdminService.assignNurse(patient, nurse);
	}

	@SuppressWarnings("unused")
	private static void get() {
		getProfile(); //WORKED

		getPokemon(); //WORKED

		getPatients(); //UPDATED

		getList(); //WORKED

	}

	private static void register() {
//		registerTrainer(); // and login WORKED
//
//		registerEmpl(); //roles and login WORKED
//
//		registerStatus(); //and meds WORKED
//
//		registerPokemon(); //and WORKED
//
//		registerPatient(); //and WORKED
		
		registerBill();

	}

	private static void registerBill() {
		Employee admin = AdminService.getNurse("2");
		StatusCondition s = NurseService.problem("Sleep");
		Medicine m = NurseService.treatment(s);

		BillingHistory b = new BillingHistory(admin, m, 16, 1600, admission);
		b = AdminService.registerBill(b);
		System.out.println(b);
	}

	private static void getMeds() {
		StatusCondition s = NurseService.problem("Burn");
		List<Medicine> m = NurseService.selectTreatment(s);
		System.out.println(m);
	}

	private static void getList() {
		List<Medicine> m = NurseService.getAllMedicines();
		List<Patient> p = NurseService.getAllPatients();
		System.out.println(m + "\n" + p);
	}

	private static void getPatients() {
		List<Patient> p = NurseService.getNursePatients(new Employee(1, "Nurse1", "1", "1", new Role(1, "Nurse")));
//		List<Patient> p = NurseService.getNursePatients(1);
		System.out.println(p);
	} 

	private static void releasePatient() {
		Patient p = NurseService.findPatient(14);
//		StatusCondition s = NurseService.problem("Sleep");
//		Medicine m = NurseService.treatment(s);

		if (AdminService.release(p)) {
			System.out.println("WORKED");
		} else {
			System.out.println("FAIL");
		}
	}

	private static void updateProfile() {
		Trainer t = TrainerService.updateProfile(new Trainer(1, "Ash", "Pallet City", "fire", "red"));
		System.out.println(t);
		
		Role nurse = new Role(1, "Nurse");
		Role admin = new Role(2, "Admin");

		Employee n = new Employee(1, "TEST1", "1", "1", nurse); // WORKED
		n = new Employee(3, "TEST2", "3", "3", admin);
		NurseService.update(n);
	}

	private static void getProfile() {
		Trainer t = TrainerService.getProfile(new Trainer(1, "Ash", "Pallet Town", "fire", "red"));
		System.out.println(t);
	}

	private static void getPokemon() {
		Trainer t = new Trainer(1, "Ash", "Pallet Town", "fire", "red");
		List<Patient> pokemon = TrainerService.getPokemon(t);
		System.out.println(pokemon);
//		for(Patient p: pokemon) {
//			if(p.getTrainer().getTrainerId()==t.getTrainerId()) {
//				System.out.println(p);
//			}
//		}
//		System.out.println(TrainerService.getPokemon(t));

	}

	private static void registerStatus() {
		PokeService.registerStatus(new StatusCondition("Burn"));		
		PokeService.registerStatus(new StatusCondition("Sleep"));
		PokeService.registerStatus(new StatusCondition("Freeze"));		
		PokeService.registerStatus(new StatusCondition("Poison"));		
		PokeService.registerStatus(new StatusCondition("Paralysis"));		
		PokeService.registerStatus(new StatusCondition("Fainted"));

		PokeService.registerMedicine(new Medicine("Burn Heal", 100.5, 20, new StatusCondition(1,"Burn")));
		PokeService.registerMedicine(new Medicine("Awakening", 100, 5, new StatusCondition(2,"Sleep")));
		PokeService.registerMedicine(new Medicine("Ice Heal", 200, 15, new StatusCondition(3,"Freeze")));
		PokeService.registerMedicine(new Medicine("Antidote", 100, 5, new StatusCondition(4,"Poison")));
		PokeService.registerMedicine(new Medicine("Paralyze Heal", 200, 25, new StatusCondition(5,"Paralysis")));
		PokeService.registerMedicine(new Medicine("Max Revive", 250, 10, new StatusCondition(6,"Fainted")));

	}

	private static void registerPokemon() {
		PokeService.registerPokemon(new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"));
		PokeService.registerPokemon(new Pokemon(15, "Beedrill", "Bug", "Poison", "Swarm"));
		PokeService.registerPokemon(new Pokemon(63, "Abra", "Psychic", null, "Inner Focus"));
	}

	private static void registerPatient() {
//		new Patient(pokemon, trainer, admission, currentHP, maxHP, status, healthy);

		StatusCondition s = NurseService.problem("Sleep");
		PokeService.registerPatient(new Patient(
						new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"),
						new Trainer(1, "Ash", "Pallet Town", "fire", "red"), 
						admission, 300, 300,
						s, false));

		StatusCondition b = NurseService.problem("Burn");
		PokeService.registerPatient(new Patient(
				new Pokemon(15, "Beedrill", "Bug", "Poison", "Swarm"),
				new Trainer(2, "Lucas", "Littleroot Town", "Diamond", "pearl"), admission, 50, 100,
				b, false));

		StatusCondition f = NurseService.problem("Fainted");
		PokeService.registerPatient(new Patient(
				new Pokemon(63, "Abra", "Psychic", null, "Inner Focus"),
				new Trainer(3, "Brendan", "Twin Leaf Town", "Sapphire", "ruby"), 
				admission, 0, 20,
				f, false));

		PokeService.registerPatient(new Patient(
				new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"),
				new Trainer(2, "Lucas", "Littleroot Town", "Diamond", "pearl"), 
				admission, 150, 300,
				b, false));

		PokeService.registerPatient(new Patient(
				new Pokemon(15, "Beedrill", "Bug", "Poison", "Swarm"),
				new Trainer(3, "Brendan", "Twin Leaf Town", "Sapphire", "ruby"), 
				admission, 0, 100,
				f, false));

		PokeService.registerPatient(new Patient(
				new Pokemon(63, "Abra", "Psychic", null, "Inner Focus"),
				new Trainer(1, "Ash", "Pallet Town", "fire", "red"), 
				admission, 10, 20, 
				b, false));
	}

	public static void registerTrainer() {

		TrainerService.registerTrainer(new Trainer(1, "Ash", "Pallet Town", "fire", "red"));

		TrainerService.registerTrainer(new Trainer(2, "Lucas", "Littleroot Town", "Diamond", "pearl"));

		TrainerService.registerTrainer(new Trainer(3, "Brendan", "Twin Leaf Town", "Sapphire", "ruby"));
    
	}

	public static void registerEmpl() {
		Role nurse = new Role("Nurse");
		Role admin = new Role("Admin");

		PokeService.registerRole(nurse);
		PokeService.registerRole(admin);

		PokeService.registerEmpl(new Employee("Nurse1", "1", "1", nurse));
		PokeService.registerEmpl(new Employee("Admin2", "2", "2", admin));
		PokeService.registerEmpl(new Employee("Nurse3", "3", "3", nurse));
		PokeService.registerEmpl(new Employee("Admin4", "4", "4", admin));
		PokeService.registerEmpl(new Employee("Nurse5", "5", "5", nurse));
		PokeService.registerEmpl(new Employee("Admin6", "6", "6", admin));
	}

}
