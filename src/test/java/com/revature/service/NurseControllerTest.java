package com.revature.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.revature.controller.NurseController;
import com.revature.model.Employee;
import com.revature.model.Patient;
import com.revature.model.Pokemon;
import com.revature.model.Role;
import com.revature.model.StatusCondition;
import com.revature.model.Trainer;
import com.revature.model.dto.PatientDTO;

public class NurseControllerTest {
	
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
	
	@Test
	public void testGetAllPatients() throws Exception {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		List<Patient> patients = Arrays.asList(
				new Patient(1, 
							new Pokemon(1, "Bulbasaur", "Grass", "Poison", "Overgrow"), 
							new Trainer(1, "Ash Ketchum", "Pallet Town", "satoshi", "pikachu"), 
							time, 
							30, 45, 
							new StatusCondition(1, "Burn"), 
							new Employee(1, "Joy", "joyjoy", "chansey", new Role(1, "Nurse")), 
							null, 
							false, 
							null),
				new Patient(2, 
						    new Pokemon(282, "Gardevoir", "Psychic", "Fairy", "Trace"), 
						    new Trainer(2, "Diana", "Lumiose City", "kchamp", "kalos"), 
						    time, 
						    68, 23, 
						    new StatusCondition(2, "Sleep"), 
						    null, null, false, null)
				);
		
		List<PatientDTO> patientsDTO = new ArrayList<>();
		for (Patient p : patients) {
			PatientDTO pdto = new PatientDTO(p.getPateintid(), p.getPokemon().getDexid(), p.getTrainer().getTrainerId(),
					p.getAdmission(), p.getRelease(), p.getCurrentHP(), p.getMaxHP(), p.getStatus().getStatusId(),
					p.getMed().getMedID(), p.isHealthy());
			patientsDTO.add(pdto);
		}
		
		when(nurseService.getAllPatients()).thenReturn(patientsDTO);
		mockMvc.perform(get("/nurse/table/view-all-admitted-pokepatients"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	            .andExpect(jsonPath("$", hasSize(2)))
	            .andExpect(jsonPath("$[0].patientid", is(1)))
	            .andExpect(jsonPath("$[0].pokemonDexId", is(1)))
	            .andExpect(jsonPath("$[1].patientid", is(2)))
	            .andExpect(jsonPath("$[1].pokemonDexId", is(2)));
	    verify(nurseService, times(1)).getAllPatients();
	    verifyNoMoreInteractions(nurseService);
	}

}