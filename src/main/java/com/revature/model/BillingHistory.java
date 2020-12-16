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
@Table(name = "BillingHistory")
public class BillingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoiceid")
	private int invoiceid;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Employee admin;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Medicine medicine;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "cost", nullable = false)
	private double cost;

	@Column(name = "dateplaced")
	private Timestamp dateplaced;

	public BillingHistory(int invoiceid, Employee admin, Medicine medicine, int quantity, double cost,
			Timestamp dateplaced) {
		super();
		this.invoiceid = invoiceid;
		this.admin = admin;
		this.medicine = medicine;
		this.quantity = quantity;
		this.cost = cost;
		this.dateplaced = dateplaced;
	}

	public BillingHistory(Employee admin, Medicine medicine, int quantity, double cost, Timestamp dateplaced) {
		super();
		this.admin = admin;
		this.medicine = medicine;
		this.quantity = quantity;
		this.cost = cost;
		this.dateplaced = dateplaced;
	}

	@Override
	public String toString() {
		return "BillingHistory [invoiceid=" + invoiceid + ", admin=" + admin + ", medicine=" + medicine + ", quantity="
				+ quantity + ", cost=" + cost + ", dateplaced=" + dateplaced + "]";
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Employee getAdmin() {
		return admin;
	}

	public void setAdmin(Employee admin) {
		this.admin = admin;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Timestamp getDateplaced() {
		return dateplaced;
	}

	public void setDateplaced(Timestamp dateplaced) {
		this.dateplaced = dateplaced;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateplaced == null) ? 0 : dateplaced.hashCode());
		result = prime * result + invoiceid;
		result = prime * result + ((medicine == null) ? 0 : medicine.hashCode());
		result = prime * result + quantity;
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
		BillingHistory other = (BillingHistory) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (dateplaced == null) {
			if (other.dateplaced != null)
				return false;
		} else if (!dateplaced.equals(other.dateplaced))
			return false;
		if (invoiceid != other.invoiceid)
			return false;
		if (medicine == null) {
			if (other.medicine != null)
				return false;
		} else if (!medicine.equals(other.medicine))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}
