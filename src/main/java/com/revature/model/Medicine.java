package com.revature.model;

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
@Table(name = "Medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "medid")
	private int medID;

	@Column(name = "medname", nullable = false, unique = true)
	private String medName;

	@Column(name = "cost", nullable = false)
	private double cost;

	@Column(name = "stock", nullable = false)
	private int stock;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private StatusCondition status; // The status condition recommended for

	public Medicine() {
		// TODO Auto-generated constructor stub
	}

	public int getMedID() {
		return medID;
	}

	public void setMedID(int medID) {
		this.medID = medID;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public StatusCondition getStatus() {
		return status;
	}

	public void setStatus(StatusCondition status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + medID;
		result = prime * result + ((medName == null) ? 0 : medName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + stock;
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
		Medicine other = (Medicine) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (medID != other.medID)
			return false;
		if (medName == null) {
			if (other.medName != null)
				return false;
		} else if (!medName.equals(other.medName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nMedicine [" + "\nmedID=" + medID + ", medName=" + medName + "\ncost=" + cost + ", stock=" + stock
				+ "\nstatus=" + status + "]";
	}

	public Medicine(int medID, String medName, double cost, int stock, StatusCondition status) {
		super();
		this.medID = medID;
		this.medName = medName;
		this.cost = cost;
		this.stock = stock;
		this.status = status;
	}

	public Medicine(String medName, double cost, int stock, StatusCondition status) {
		super();
		this.medName = medName;
		this.cost = cost;
		this.stock = stock;
		this.status = status;
	}

}
