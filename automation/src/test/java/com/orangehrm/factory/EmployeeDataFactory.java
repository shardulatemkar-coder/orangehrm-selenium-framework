package com.orangehrm.factory;
import com.orangehrm.pages.Employee;

public  class EmployeeDataFactory {

	    public static Employee createEmployee() {

	        
	    	String firstName = "AutoFN";
	    	String middleName = "Mid";
	    	String lastName = "LN";
	    	String empId = "EMP";

	        return new Employee(firstName,middleName,lastName,empId);
	    }
	}
