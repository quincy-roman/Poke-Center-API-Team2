package com.revature.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.controller.NurseController;

public class NurseControllerTest {
	
	@SuppressWarnings("unused")
	private MockMvc mockMvc;
	
	@Mock
	private NurseService nurseService;
	
	@InjectMocks
	private NurseController nurseController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(nurseController).build();
	}
	
//	@Test
//	public void testGetAllPatients() throws Exception {
////		Timestamp time = System.currentTimeMillis();
//		List<Patient> patients = Arrays.asList(
//				new Patient(1, 
//							new Pokemon(1, "Bulbasaur", "Grass", "Poison", "Overgrow"), 
//							new Trainer(1, "Ash Ketchum", "Pallet Town", "satoshi", "pikachu"), 
//							new Timestamp, 
//							currentHP, maxHP, 
//							status, 
//							nurseid, 
//							med, 
//							healthy, 
//							release),
//				new Patient(2, pokemon, trainer, admission, currentHP, maxHP, status, nurseid, med, healthy, release)
//				);
//	}

}
