package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this acts like the SERIAL datatype in SQL
	@Column(name = "roleid")
	private int roleid; //Trainer 1, Nurse 2, Admin 3

	@Column(name = "role", nullable = false)
	private String role;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	

}
