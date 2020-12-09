package com.revature.model.dto;

import java.util.List;

import com.revature.model.Pokemon;

public class NurseDTO {
	
	private String username;
	private String password;
	private String name;
	private List<Pokemon> patients;	//TODO switch type to Patients when that is created.
	
	public NurseDTO() {}

	public NurseDTO(String username, String password, String name, List<Pokemon> patients) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.patients = patients;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getPatients() {
		return patients;
	}

	public void setPatients(List<Pokemon> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "NurseDTO [username=" + username + ", password=" + password + ", name=" + name + ", patients=" + patients
				+ "]";
	}
	
}
