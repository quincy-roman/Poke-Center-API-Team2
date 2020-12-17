package com.revature.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CorsFilter;

import com.revature.controller.NurseController;

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
	

}
