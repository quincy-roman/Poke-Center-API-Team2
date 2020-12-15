package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pateintid")
	private int pateintid;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Pokemon pokemon;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Trainer trainer;
	
	@Column(name = "admission", nullable = false)
	private Timestamp admission;

	@Column(name="currentHP", nullable = false)
	private int currentHP;
	
	@Column(name="maxHP", nullable = false)
	private int maxHP;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private StatusCondition status;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Employee nurseid;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Medicine med;	
	
	@Column(name = "healthy", nullable = false)
	private boolean healthy;
	
	@Column(name = "release")
	private Timestamp release;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int pateintid, Pokemon pokemon, Trainer trainer, Timestamp admission, int currentHP, int maxHP,
			StatusCondition status, Employee nurseid, Medicine med, boolean healthy, Timestamp release) {
		super();
		this.pateintid = pateintid;
		this.pokemon = pokemon;
		this.trainer = trainer;
		this.admission = admission;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.status = status;
		this.nurseid = nurseid;
		this.med = med;
		this.healthy = healthy;
		this.release = release;
	}

	public Patient(Pokemon pokemon, Trainer trainer, Timestamp admission, int currentHP, int maxHP,
			StatusCondition status, Employee nurseid, Medicine med, boolean healthy, Timestamp release) {
		super();
		this.pokemon = pokemon;
		this.trainer = trainer;
		this.admission = admission;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.status = status;
		this.nurseid = nurseid;
		this.med = med;
		this.healthy = healthy;
		this.release = release;
	}

	public int getPateintid() {
		return pateintid;
	}

	public void setPateintid(int pateintid) {
		this.pateintid = pateintid;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Timestamp getAdmission() {
		return admission;
	}

	public void setAdmission(Timestamp admission) {
		this.admission = admission;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public StatusCondition getStatus() {
		return status;
	}

	public void setStatus(StatusCondition status) {
		this.status = status;
	}

	public Employee getNurseid() {
		return nurseid;
	}

	public void setNurseid(Employee nurseid) {
		this.nurseid = nurseid;
	}

	public Medicine getMed() {
		return med;
	}

	public void setMed(Medicine med) {
		this.med = med;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

	public Timestamp getRelease() {
		return release;
	}

	public void setRelease(Timestamp release) {
		this.release = release;
	}

	@Override
	public String toString() {
		return "\nPatient ["
				+ "\npateintid=" + pateintid
				+ ", \npokemon=" + pokemon 
				+ ", \ntrainer=" + trainer 
				+ ", \nadmission="
				+ admission + ", currentHP=" + currentHP + ", maxHP=" + maxHP + ", \nstatus=" + status + ", \nnurseid="
				+ nurseid + ", \nmed=" + med + ", healthy=" + healthy + ", release=" + release + "]";
	}

	
}
