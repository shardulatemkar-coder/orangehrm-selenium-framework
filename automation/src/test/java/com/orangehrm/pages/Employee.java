package com.orangehrm.pages;

public class Employee {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String employeeId;
	
	public Employee(String firstName, String middleName, String lastName, String employeeId) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.employeeId = employeeId;
	}

	public String firstName() {
		return firstName;
	}

	public String middleName() {
		return middleName;
	}

	public String lastName() {
		return lastName;
	}

	public String employeeId() {
		return employeeId;
	}
	
	public String fullName() {
		return firstName + " " + lastName;
	}
}
