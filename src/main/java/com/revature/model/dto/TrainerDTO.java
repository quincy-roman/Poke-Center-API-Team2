package com.revature.model.dto;

public class TrainerDTO {

	private int trainerid;
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

	@Override
	public String toString() {
<<<<<<< HEAD
		return "TrainerDTO [trainerid=" + trainerid + ", name=" + name + ", hometown=" + hometown + ", username="
				+ username + ", password=" + password + "]";
	}	
=======
		return "TrainerDTO [name=" + name + ", hometown=" + hometown + ", username=" + username + ", password="
				+ password + "]";
	}
>>>>>>> a1921d6c68ce5ea0ff6c78089c475ae2124c9052

}