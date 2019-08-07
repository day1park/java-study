package com;

import java.util.Scanner;

public class StudentOperations {
	
	public static int findStudent(Student[] students, int studentId) {
		for (Student student : students) {
			if(student.getStudentId() == studentId) {
				return 1;
			}
		}
		return -1;
	}
	
	public static boolean isStudentAvailable(String studentType, Student[] students) {
		for (Student student : students) {
			if (student.getStudentType().equals(studentType)) {
				return true;
			} 	
		}
		return false;
	}


	public static Student getLowestScoredStudent(Student[] students) {
		double lowestMark = 9999;
		Student lowestStudent = null;
		for (Student student : students) {
			if (student.getStudentMarks() < lowestMark) {
				lowestMark = student.getStudentMarks();
				lowestStudent = student;
			}
		}
		return lowestStudent;
	}
	
	public static int displayHighestCountOfStudents(Student[] students) {
		int hTotal = 0;
		int dTotal = 0;
		for(int i = 0; i <students.length; i++) {
			if(students[i].getStudentType().equals("dayscholar")) {
				dTotal++;
			} else {
				hTotal++;
			}
		}
		if(hTotal> dTotal) {
			return hTotal;
		} else if (dTotal>hTotal) {
			return dTotal;
		} else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("please enter number of students");
		int amount = sc.nextInt();
		
		System.out.println("please enter student ID, student Type and student marks");
		Student[] students = new Student[amount];
		for (int i = 0; i <amount; i++) {
			students[i] = new Student(sc.nextInt(), sc.next(), sc.nextDouble());
		}
		
		Student a;
		boolean bool;
		int b;

		
		boolean isFinished = false;
		while(!isFinished) {
			System.out.println("\nWelcome school directory, please select from the following options:");

			System.out.println("1: find student");
			System.out.println("2: check if certain student type is at this school");
			System.out.println("3: find the details of the student with the lowest score");
			System.out.println("4: find the highest count of students of either type");
			System.out.println("0: Exit");

			int option = sc.nextInt();
			if (option == 0) {  // End the program
				isFinished = true;
			} else if (option == 1) {
				System.out.println("\nSearch student by id");
				b = findStudent(students, sc.nextInt());
				if(b == -1) {
					System.out.println("student doesnt exist");
				} else {
					System.out.println("yes the student id exists" );
				}
				
			} else if (option == 2) {
				System.out.println("\nPlease enter student type: ");
				String typeInput = sc.next().toLowerCase();
				if(!typeInput.equals("dayscholar") && !typeInput.equals("hostel")) {
					System.out.println("no " + typeInput + " type of student does not exist");
				} else {
					bool = isStudentAvailable(typeInput, students);
					if (bool) {
						System.out.println(typeInput + " type of students exists");
					} else {
						System.out.println(typeInput + " type of student does NOT exist");
					}
				}
			} else if (option == 3) {
				a = getLowestScoredStudent(students);
				System.out.println("\nThe lowest scoring student id is: " + a.getStudentId() + " and their mark is " + a.getStudentMarks());
			} else if (option == 4) {
				b = displayHighestCountOfStudents(students);
				if (b == -1) {
					System.out.println("both dayscholar and hostel amount is the same");
				} else {
					System.out.println("the highest count of students in a certain student type is " + b);
				}
			} else {
				System.out.println("\nPlease enter from options 0 - 4");
			}
		}
	}

}

