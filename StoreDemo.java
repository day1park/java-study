package com;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreDemo {
	public static boolean checkItem(Item[] items, String itemName) {
		for (Item item: items) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}
	
	public static double getAverageItemPrice(Item[] items) {
		double totalPrice = 0;
		for (Item item: items) {
			totalPrice += item.getItemPrice();
		}
		return totalPrice /= items.length;
	}
	
	public static int getItemCode(Item[] items, String itemName) {
		for (Item item: items) {
			if (item.getItemName().equals(itemName)) {
				return item.getItemCode();
			}
		}
		return -1;
	}
	
	public static Item[] getItemsWithSpecificPrice(Item[] items, double itemPrice) {
		ArrayList<Item> results = new ArrayList<>();
		int size = 0;
		for (Item item: items) {
			if (item.getItemPrice() == itemPrice) {
				results.add(item);
				size++;
			}
		}
		return results.toArray(new Item[size]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter amount of store items: ");
		// Get user input for the amount of store items
		int amount = sc.nextInt();

		System.out.println("Please enter item code, item name and item price:");
		Item[] items = new Item[amount];
		for (int i = 0; i < amount; i++) {
			items[i] = new Item(sc.nextInt(), sc.next(), sc.nextDouble());
		}

		boolean temp1;
		double temp2;
		int temp3;
		Item[] temp4;

		boolean isFinished = false;
		while (!isFinished) {
			System.out.println("\nPlease enter one of the options from below:");
			System.out.println("0: End program");
			System.out.println("1: Check if item exists");
			System.out.println("2: Get average item price");
			System.out.println("3: Get the item code of an item");
			System.out.println("4: Get items with a specific price");
			
			int option = sc.nextInt();
			if (option == 0) {  // End the program
				isFinished = true;
			} else if (option == 1) {  // Part A
				System.out.print("\nPlease enter an item's name: ");
				String tempName = sc.next().toLowerCase();
				temp1 = checkItem(items, tempName);
				if (temp1) {
					System.out.println(tempName + " exist!");
				} else {
					System.out.println(tempName + " doesn't exist!");
				}
			} else if (option == 2) {  // Part B
				temp2 = getAverageItemPrice(items);
				System.out.println("\nThe average price of all items is $" + temp2);
			} else if (option == 3) {  // Part C
				System.out.print("\nPlease enter an item's name: ");
				String tempName = sc.next().toLowerCase();
				temp3 = getItemCode(items, tempName);
				if (temp3 != -1) {
					System.out.println(tempName + "'s item code is " + temp3);
				} else {
					System.out.println(tempName + " doesn't exist!");
				}
			} else if (option == 4) {  // Part D
				System.out.print("\nPlease enter a price: ");
				temp4 = getItemsWithSpecificPrice(items, sc.nextDouble());
				if (temp4.length > 0) {
					for (Item item: temp4) {
						System.out.println(item.getItemCode() + " - " + item.getItemName() + ", $" + item.getItemPrice());
					}
				} else {
					System.out.println("There are no items with this specific price!");
				}
			} else {
				System.out.println("\nPlease enter one of the options!");
			}
		}
	}
}
