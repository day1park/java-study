package com;

public class Student {
	private int studentId;
	private String studentType;
	private double studentMarks;
	
	Student(int studentId, String studentType, double studentMarks) {
		this.studentId = studentId;
		this.studentType = studentType.toLowerCase();
		this.studentMarks = studentMarks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType.toLowerCase();
	}

	public double getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(double studentMarks) {
		this.studentMarks = studentMarks;
	}
	
}
