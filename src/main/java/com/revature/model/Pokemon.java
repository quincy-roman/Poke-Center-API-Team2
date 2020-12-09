package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pokemon")
public class Pokemon {

	@Id
	@Column(name="dexid")
	private int dexid;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="type1", nullable = false)
	private String type1;
	
	@Column(name="type1")
	private String type2;
	
	@Column(name="ability", nullable = false)
	private String ability;
	
	//@Column(name="category", nullable = false)
	//private String category;
	
	
	
}
