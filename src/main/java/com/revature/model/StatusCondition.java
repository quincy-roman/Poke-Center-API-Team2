package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_condition")
public class StatusCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this acts like the SERIAL datatype in SQL
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_seq")
//	@SequenceGenerator(name = "status_seq", sequenceName = "status_seq", allocationSize = 1)
	@Column(name = "status_id")
	private int statusId;

	@Column(name = "status_name", nullable = false, unique = true)
	private String statusName; // Burn, Freeze, Sleep, Poison, paralysis, Fainted

	public StatusCondition() {
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + statusId;
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
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
		StatusCondition other = (StatusCondition) obj;
		if (statusId != other.statusId)
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		return true;
	}

}
