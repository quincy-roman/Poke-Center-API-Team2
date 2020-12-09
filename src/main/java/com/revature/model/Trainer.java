package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="trainer_seq")
	@SequenceGenerator(name="trainer_seq", sequenceName="trainer_seq", allocationSize=1)
	@Column(name="trainer_id")
	private int trainerId;

	@Column(name="trainer_name")
	private String trainerName;

	// Trainers need login info. We could potentially make Login_Info a 
	// separate table and have trainers and employees
	// have foreign keys to their related info.

	@Column(name="trainer_username")
	private String username;

	@Column(name="trainer_password")
	private String password;	//TODO incorporate BCrypt or something.

	@OneToMany(mappedBy="pokemon")	//TODO this is fit to change, probably to Patients
	private List<Pokemon> pokemon;

	public Trainer() {}

	// Without id.
	public Trainer(String trainerName, String username, String password, List<Pokemon> pokemon) {
		super();
		this.trainerName = trainerName;
		this.username = username;
		this.password = password;
		this.pokemon = pokemon;
	}

	// With id.
	public Trainer(int trainerId, String trainerName, String username, String password, List<Pokemon> pokemon) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.username = username;
		this.password = password;
		this.pokemon = pokemon;
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

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", username=" + username
				+ ", password=" + password + ", pokemon=" + pokemon + "]";
	}

}
