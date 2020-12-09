package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="status_condition")
public class StatusCondition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status_seq")
	@SequenceGenerator(name="status_seq", sequenceName="status_seq", allocationSize=1)
	@Column(name="status_id")
	private int statusId;
	
	@Column(name="status_name")
	private String statusName;
	
	public StatusCondition() {}

	public StatusCondition(String statusName) {
		super();
		this.statusName = statusName;
	}

	public StatusCondition(int statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "StatusCondition [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
	

}
