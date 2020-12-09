package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pokemon")
public class Pokemon {

	@Id
	@Column(name="nationalid")
	private int nationalid;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="type1", nullable = false)
	private String type1;
	
	@Column(name="type1")
	private String type2;
	
	@Column(name="ability", nullable = false)
	private String ability;
	
	@Column(name="category", nullable = false)
	private String category;
	
	public Pokemon(String name, String type1, String type2, String ability, String category) {
		super();
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.ability = ability;
		this.category = category;
	}

	public Pokemon(int nationalid, String name, String type1, String type2, String ability, String category) {
		super();
		this.nationalid = nationalid;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.ability = ability;
		this.category = category;
	}

	public int getNationalid() {
		return nationalid;
	}

	public void setNationalid(int nationalid) {
		this.nationalid = nationalid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ability == null) ? 0 : ability.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nationalid;
		result = prime * result + ((type1 == null) ? 0 : type1.hashCode());
		result = prime * result + ((type2 == null) ? 0 : type2.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (ability == null) {
			if (other.ability != null)
				return false;
		} else if (!ability.equals(other.ability))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationalid != other.nationalid)
			return false;
		if (type1 == null) {
			if (other.type1 != null)
				return false;
		} else if (!type1.equals(other.type1))
			return false;
		if (type2 == null) {
			if (other.type2 != null)
				return false;
		} else if (!type2.equals(other.type2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [nationalid=" + nationalid + ", name=" + name + ", type1=" + type1 + ", type2=" + type2
				+ ", ability=" + ability + ", category=" + category + "]";
	}
	
	
}
