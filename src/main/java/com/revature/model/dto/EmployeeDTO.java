package com.revature.model.dto;

public class EmployeeDTO {

	private String username;
	private String password;
	private String name;
	private int roleid;

	public EmployeeDTO() {}

	public EmployeeDTO(String username, String password, String name, int roleid) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.roleid = roleid;
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

	public int getRoleId() {
		return roleid;
	}

	public void setPatients(int roleId) {
		this.roleid = roleId;
	}

	@Override
	public String toString() {
		return "NurseDTO [username=" + username + ", password=" + password + ", name=" + name + ", roleid=" + roleid
				+ "]";
	}

}