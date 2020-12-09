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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pokemon pokemon;
	
	@Column(name="currentHP")
	private int currentHP;
	
	@Column(name="maxHP")
	private int maxHP;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private StatusCondition status;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Trainer trainer;
	
	@Column(name = "admission", nullable = false)
	private Timestamp admission;
		
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Employee nurseid;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Medicine med;	
	
	@Column(name = "release")
	private Timestamp release;

	public Patient(int pateintid, Pokemon pokemon, int currentHP, int maxHP, StatusCondition status, Trainer trainer,
			Timestamp admission, Employee nurseid, Medicine med, Timestamp release) {
		super();
		this.pateintid = pateintid;
		this.pokemon = pokemon;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.status = status;
		this.trainer = trainer;
		this.admission = admission;
		this.nurseid = nurseid;
		this.med = med;
		this.release = release;
	}

	public Patient(Pokemon pokemon, int currentHP, int maxHP, StatusCondition status, Trainer trainer,
			Timestamp admission, Employee nurseid, Medicine med, Timestamp release) {
		super();
		this.pokemon = pokemon;
		this.currentHP = currentHP;
		this.maxHP = maxHP;
		this.status = status;
		this.trainer = trainer;
		this.admission = admission;
		this.nurseid = nurseid;
		this.med = med;
		this.release = release;
	}

	@Override
	public String toString() {
		return "Patient [pateintid=" + pateintid + ", pokemon=" + pokemon + ", currentHP=" + currentHP + ", maxHP="
				+ maxHP + ", status=" + status + ", trainer=" + trainer + ", admission=" + admission + ", nurseid="
				+ nurseid + ", med=" + med + ", release=" + release + "]";
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

	public Timestamp getRelease() {
		return release;
	}

	public void setRelease(Timestamp release) {
		this.release = release;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
		result = prime * result + currentHP;
		result = prime * result + maxHP;
		result = prime * result + ((med == null) ? 0 : med.hashCode());
		result = prime * result + ((nurseid == null) ? 0 : nurseid.hashCode());
		result = prime * result + pateintid;
		result = prime * result + ((pokemon == null) ? 0 : pokemon.hashCode());
		result = prime * result + ((release == null) ? 0 : release.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		Patient other = (Patient) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
		if (currentHP != other.currentHP)
			return false;
		if (maxHP != other.maxHP)
			return false;
		if (med == null) {
			if (other.med != null)
				return false;
		} else if (!med.equals(other.med))
			return false;
		if (nurseid == null) {
			if (other.nurseid != null)
				return false;
		} else if (!nurseid.equals(other.nurseid))
			return false;
		if (pateintid != other.pateintid)
			return false;
		if (pokemon == null) {
			if (other.pokemon != null)
				return false;
		} else if (!pokemon.equals(other.pokemon))
			return false;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}
	
	

}
