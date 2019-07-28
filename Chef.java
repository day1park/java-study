package com;

public class Chef {
	private int chefID;
	private String name;
	private double salary;

	Chef(int chefID, String name, double salary) {
		this.chefID = chefID;
		this.name = name.toLowerCase();
		this.salary = salary;
	}

	public int getChefID() {
		return chefID;
	}

	public void setChefID(int chefID) {
		this.chefID = chefID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
