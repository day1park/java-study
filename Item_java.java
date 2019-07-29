package com;

public class Item {
	private int itemCode;
	private String itemName;
	private double itemPrice;

	Item(int itemCode, String itemName, double itemPrice) {
		this.itemCode = itemCode;
		this.itemName = itemName.toLowerCase();
		this.itemPrice = itemPrice;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName.toLowerCase();
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
}
