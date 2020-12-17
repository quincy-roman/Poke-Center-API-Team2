package com.revature.model.dto;
public class TrainerDTO {
	private int trainerid;
	private String name;
	private String hometown;
	private String username;
	private String password;
	private int roleId = 3;

	public TrainerDTO() {
	}
	public TrainerDTO(String name, String hometown, String username, String password) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.username = username;
		this.password = password;
	}
	public TrainerDTO(int trainerid, String name, String hometown, String username, String password) {
		super();
		this.trainerid = trainerid;
		this.name = name;
		this.hometown = hometown;
		this.username = username;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
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
	public int getTrainerid() {
		return trainerid;
	}
	public void setTrainerid(int trainerid) {
		this.trainerid = trainerid;
	}

	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = 3;
	}
	@Override
	public String toString() {
		return "TrainerDTO [trainerid=" + trainerid + ", name=" + name + ", hometown=" + hometown + ", username="
				+ username + ", password=" + password + "]";
	}
}