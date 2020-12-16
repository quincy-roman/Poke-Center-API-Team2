package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer_seq")
	@SequenceGenerator(name = "trainer_seq", sequenceName = "trainer_seq", allocationSize = 1)
	@Column(name = "trainer_id")
	private int trainerId;

	@Column(name = "trainer_name", nullable = false)
	private String trainerName;

	@Column(name = "hometown", nullable = false)
	private String hometown;

	@Column(name = "trainer_username", nullable = false, unique = true)
	private String username;

	@Column(name = "trainer_password", nullable = false)
	private String password; 

	public Trainer() {
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Trainer(String trainerName, String hometown, String username, String password) {
		super();
		this.trainerName = trainerName;
		this.hometown = hometown;
		this.username = username;
		this.password = password;
	}

	public Trainer(int trainerId, String trainerName, String hometown, String username, String password) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.hometown = hometown;
		this.username = username;
		this.password = password;
	}

	// Without id.
	public Trainer(String trainerName, String username, String password, List<Pokemon> pokemon) {
		super();
		this.trainerName = trainerName;
		this.username = username;
		this.password = password;
		// this.pokemon = pokemon;
	}

	// With id.
	public Trainer(int trainerId, String trainerName, String username, String password, List<Pokemon> pokemon) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.username = username;
		this.password = password;
		// this.pokemon = pokemon;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
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

//	public List<Pokemon> getPokemon() {
//		return pokemon;
//	}
//
//	public void setPokemon(List<Pokemon> pokemon) {
//		this.pokemon = pokemon;
//	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", hometown=" + hometown
				+ ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hometown == null) ? 0 : hometown.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + trainerId;
		result = prime * result + ((trainerName == null) ? 0 : trainerName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		if (hometown == null) {
			if (other.hometown != null)
				return false;
		} else if (!hometown.equals(other.hometown))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (trainerId != other.trainerId)
			return false;
		if (trainerName == null) {
			if (other.trainerName != null)
				return false;
		} else if (!trainerName.equals(other.trainerName))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
