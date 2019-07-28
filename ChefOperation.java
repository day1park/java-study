package com;

import java.util.Scanner;

public class ChefOperation {
	public Chef findChef(int chefID, Chef[] chefs) {
		for (Chef chef: chefs) {
			if (chef.getChefID() == chefID) {
				return chef;
			}
		}
		return null;
	}
	
	public boolean searchChef(String chefName, Chef[] chefs) {
		for (Chef chef: chefs) {
			if (chef.getName().equals(chefName)) {
				return true;
			}
		}
		return false;
	}
	
	public Chef getHighestPaidChef(Chef[] chefs) {
		double highestSalary = 0;
		Chef highestPaidChef = null;
		for (Chef chef: chefs) {
			if (chef.getSalary() > highestSalary) {
				highestSalary = chef.getSalary();
				highestPaidChef = chef;
			}
		}
		return highestPaidChef;
	}
	
	public int countSpecialization(String[][] chefsAndDishes, String chefName) {
		for (String[] chefAndDish: chefsAndDishes) {
			if (chefAndDish[0].equals(chefName)) {
				String[] dishes = chefAndDish[1].trim().split(" ");
				if (dishes.length == 1) {
					return dishes[0].equals("") || dishes[0].equals(" ") ? 0 : 1;
				}
				return dishes.length;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ChefOperation demo = new ChefOperation();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter amount of chefs: ");
		// Get user input for the amount of chefs
		int amount = sc.nextInt();

		System.out.println("Please enter chefID, name and salary:");
		Chef[] chefs = new Chef[amount];
		String[][] chefsAndDishes = new String[amount][2];
		int chefID;
		String chefName;
		double chefSalary;
		String chefSpecs;
		for (int i = 0; i < amount; i++) {
			chefID = sc.nextInt();
			chefName = sc.next();
			chefSalary = sc.nextDouble();
			sc.nextLine();
			chefSpecs = sc.nextLine();
			chefs[i] = new Chef(chefID, chefName, chefSalary);
			chefsAndDishes[i][0] = chefName.toLowerCase();
			chefsAndDishes[i][1] = chefSpecs;
		}

		Chef temp1;
		boolean temp2;
		String temp3;
		int temp4;
		
		boolean isFinished = false;
		while (!isFinished) {
			System.out.println("\nPlease enter one of the options from below:");
			System.out.println("0: End program");
			System.out.println("1: Find chef by ID");
			System.out.println("2: Check if chef exists");
			System.out.println("3: Find highest paid chef");
			System.out.println("4: Count specialization of certain chef");
			
			int option = sc.nextInt();
			if (option == 0) {  // End the program
				isFinished = true;
			} else if (option == 1) {  // Part A
				System.out.print("\nPlease enter a chef ID: ");
				temp1 = demo.findChef(sc.nextInt(), chefs);
				if (temp1 != null) {
					System.out.println(temp1.getName() + ", $" + temp1.getSalary());
				} else {
					System.out.println("Chef doesn't exist!");
				}
			} else if (option == 2) {  // Part B
				System.out.print("\nPlease enter a chef name: ");
				String tempName = sc.next().toLowerCase();
				temp2 = demo.searchChef(tempName, chefs);
				if (temp2) {
					System.out.println(tempName + " exists!");
				} else {
					System.out.println(tempName + " doesn't exist!");
				}
			} else if (option == 3) {  // Part C
				temp1 = demo.getHighestPaidChef(chefs);
				System.out.println("\nThe highest paid chef is: " + temp1.getName() + ", $" + temp1.getSalary());
			} else if (option == 4) {  // Part D
				System.out.print("\nPlease enter a chef name: ");
				temp3 = sc.next().toLowerCase();
				temp4 = demo.countSpecialization(chefsAndDishes, temp3);
				if (temp4 == -1) {
					System.out.println(temp3 + " doesn't exist!");
				} else if (temp4 > 0) {
					System.out.println(temp3 + " has " + temp4 + " specializations.");
				} else {
					System.out.println(temp3 + " has no specializations");
				}
			} else {
				System.out.println("\nPlease enter one of the options!");
			}
		}
	}
}
