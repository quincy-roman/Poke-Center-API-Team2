package com.revature.model.dto;

public class TrainerDTO {

	private String name;
	private String hometown;
	private String username;
	private String password;

	public TrainerDTO() {
	}

	public TrainerDTO(String name, String hometown, String username, String password) {
		super();
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

	@Override
	public String toString() {
		return "TrainerDTO [name=" + name + ", hometown=" + hometown + ", username=" + username + ", password="
				+ password + "]";
	}

}