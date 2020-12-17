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
import com.revature.model.dto.MedicineDTO;
import com.revature.model.dto.PatientDTO;
import com.revature.model.dto.TrainerDTO;
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
		
		get();
		
		functions();
	}

	@SuppressWarnings("unused")
	private static void functions() {
		updateProfile(); // WORKED

		assignnurse(); // WORKED

		getMeds(); // WORKED

		treatment(); // WORKED

		declarehealthy(); // WORKED

		releasePatient(); // WORKED

	}

	private static void declarehealthy() {
		Patient p = NurseService.findPatient(7);
		boolean h = NurseService.declarehealthy(p);
		System.out.println(h);
	}

	private static void treatment() {
		Patient p = NurseService.findPatient(7);
		StatusCondition s = NurseService.problem("Sleep");
		Medicine m = NurseService.treatment(s);
		boolean h = NurseService.applytreatment(p, m);
		System.out.println(h);
	}

	private static void assignnurse() {
		Patient patient = NurseService.findPatient(7);
		Employee nurse = AdminService.getNurse("1");
		AdminService.assignNurse(patient.getPateintid(), nurse.getUsername());
	}

	@SuppressWarnings("unused")
	private static void get() {
		getProfile(); // WORKED

		getPokemon(); // WORKED

		getPatients(); // UPDATED

		getList(); // WORKED

	}

	@SuppressWarnings("unused")
	private static void register() {
//		registerTrainer(); // and login WORKED
//
//		registerEmpl(); // roles and login WORKED
//
//		registerStatus(); // and meds WORKED
//
		registerPokemon(); // and WORKED
//
//		registerPatient(); // and WORKED
//
//		registerBill(); // and WORKED

	}

	@SuppressWarnings("unused")
	private static void registerBill() {
		Employee admin = AdminService.getNurse("2");
		StatusCondition s = NurseService.problem("Sleep");
		Medicine m = NurseService.treatment(s);

		BillingHistory b = new BillingHistory(admin, m, 16, 1600, admission);
		b = AdminService.registerBill(b);
		System.out.println(b);
	}

	private static void getMeds() {
		StatusCondition s = NurseService.problem("Sleep");
		List<MedicineDTO> m = NurseService.selectTreatment(s);
		System.out.println(m);
	}

	private static void getList() {
		List<MedicineDTO> m = NurseService.getAllMedicines();
		List<PatientDTO> p = NurseService.getAllPatients();
		System.out.println(m + "\n" + p);
	}

	private static void getPatients() {
		List<PatientDTO> p = NurseService.getNursePatients(new Employee(1, "Nurse1", "1", "1", new Role(1, "Nurse")));
//		List<Patient> p = NurseService.getNursePatients(1);
		System.out.println(p);
	}

	private static void releasePatient() {
		Patient p = NurseService.findPatient(7);
		if (AdminService.release(p)) {
			System.out.println("WORKED");
		} else {
			System.out.println("FAIL");
		}
	}

	@SuppressWarnings("unused")
	private static void updateProfile() {
		TrainerDTO t = TrainerService.updateProfile(new Trainer(1, "Ash", "Pallet City", "fire", "red"));
		System.out.println(t);

		Role nurse = new Role(1, "Nurse");
		Role admin = new Role(2, "Admin");

		Employee n = new Employee(1, "TEST1", "1", "1", nurse); // WORKED
		n = new Employee(3, "TEST2", "3", "3", admin);
		NurseService.update(n);
	}

	private static void getProfile() {
		TrainerDTO t = TrainerService.getProfile(new Trainer(1, "Ash", "Pallet Town", "fire", "red"));
		System.out.println(t);
	}

	private static void getPokemon() {
		Trainer t = new Trainer(1, "Ash", "Pallet Town", "fire", "red");
		List<PatientDTO> pokemon = TrainerService.getPokemon(t);
		System.out.println(pokemon);
	}

	@SuppressWarnings("unused")
	private static void registerStatus() {
		PokeService.registerStatus(new StatusCondition("Burn"));
		PokeService.registerStatus(new StatusCondition("Sleep"));
		PokeService.registerStatus(new StatusCondition("Freeze"));
		PokeService.registerStatus(new StatusCondition("Poison"));
		PokeService.registerStatus(new StatusCondition("Paralysis"));
		PokeService.registerStatus(new StatusCondition("Fainted"));

		PokeService.registerMedicine(new Medicine("Burn Heal", 100.5, 20, new StatusCondition(1, "Burn")));
		PokeService.registerMedicine(new Medicine("Awakening", 100, 5, new StatusCondition(2, "Sleep")));
		PokeService.registerMedicine(new Medicine("Ice Heal", 200, 15, new StatusCondition(3, "Freeze")));
		PokeService.registerMedicine(new Medicine("Antidote", 100, 5, new StatusCondition(4, "Poison")));
		PokeService.registerMedicine(new Medicine("Paralyze Heal", 200, 25, new StatusCondition(5, "Paralysis")));
		PokeService.registerMedicine(new Medicine("Max Revive", 250, 10, new StatusCondition(6, "Fainted")));

	}

	private static void registerPokemon() {
		PokeService.registerPokemon(new Pokemon("Venasuar", "Grass", "Poison", "Overgrow"));
		PokeService.registerPokemon(new Pokemon("Beedrill", "Bug", "Poison", "Swarm"));
		PokeService.registerPokemon(new Pokemon("Abra", "Psychic", null, "Inner Focus"));
	}

	@SuppressWarnings("unused")
	private static void registerPatient() {
//		new Patient(pokemon, trainer, admission, currentHP, maxHP, status, healthy);

//		StatusCondition s = NurseService.problem("Sleep");
//		TrainerService.registerPatient(
//				new Patient(
//				null,
//				null, 
//				null, 300, 300, null, false), 
//				1, "Venasuar", "Sleep");
//
//		StatusCondition b = NurseService.problem("Burn");
//		TrainerService.registerPatient(
//				new Patient(
//				null,
//				null,
//				null, 50, 100, null, false), 
//				2, "beedrill", "Burn");
//
//		StatusCondition f = NurseService.problem("Fainted");
//		TrainerService.registerPatient(new Patient(new Pokemon(63, "Abra", "Psychic", null, "Inner Focus"),
//				new Trainer(3, "Brendan", "Twin Leaf Town", "Sapphire", "ruby"), admission, 0, 20, f, false), 0, null, null);
//
//		TrainerService.registerPatient(new Patient(new Pokemon(3, "Venasuar", "Grass", "Poison", "Overgrow"),
//				null, admission, 150, 300, b, false), 2, null, null);
//
//		TrainerService.registerPatient(new Patient(new Pokemon(15, "Beedrill", "Bug", "Poison", "Swarm"),
//				new Trainer(3, "Brendan", "Twin Leaf Town", "Sapphire", "ruby"), admission, 0, 100, f, false), 0, null, null);
//
//		TrainerService.registerPatient(new Patient(new Pokemon(63, "Abra", "Psychic", null, "Inner Focus"),
//				new Trainer(1, "Ash", "Pallet Town", "fire", "red"), admission, 10, 20, b, false), 0, null, null);
	}

	public static void registerTrainer() {

		TrainerService.registerTrainer(new Trainer("Gary", "Pallet Town", "fire", "red"));

		TrainerService.registerTrainer(new Trainer("Lucas", "Littleroot Town", "Diamond", "pearl"));

		TrainerService.registerTrainer(new Trainer("Brendan", "Twin Leaf Town", "Sapphire", "ruby"));

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
