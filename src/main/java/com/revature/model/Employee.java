package com.revature.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(name="employee_seq", sequenceName="employee_seq", allocationSize=1)
	@Column(name="employee_id")
	private int employeeId;

	@Column(name="employee_name")
	private String employeeName;

	// Check the note in Trainer.java
	@Column(name="employee_username")
	private String username;

	@Column(name="employee_password")
	private String password;	//TODO SpringSecurity for encryption?
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Role role;

	public Employee() {}

	// W/out id
	public Employee(String employeeName, String username, String password) {
		super();
		this.employeeName = employeeName;
		this.username = username;
		this.password = password;
	}

	// W/id

	public Employee(int employeeId, String employeeName, String username, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.username = username;
		this.password = password;
	}

	public Employee(int employeeId, String employeeName, String username, String password, Role role) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", username=" + username
				+ ", password=" + password + ", role=" + role + "]";
	}


}
