package com.revature.model.dto;

public class MedicineDTO {
	
	private int medId;
	private String medName;
	private double cost;
	private int stock;
	
	public MedicineDTO() {}

	public MedicineDTO(int medId, String medName, double cost, int stock) {
		super();
		this.medId = medId;
		this.medName = medName;
		this.cost = cost;
		this.stock = stock;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
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

	@Override
	public String toString() {
		return "MedicineDTO [medId=" + medId + ", medName=" + medName + ", cost=" + cost + ", stock=" + stock + "]";
	}

}
