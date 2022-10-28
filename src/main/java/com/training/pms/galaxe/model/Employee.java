package com.training.pms.galaxe.model;

import lombok.Data;

@Data
public class Employee {
	int employeeId;
	String employeeName;
	int salary;
	int pf;
	int bonus;
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}

//If you want to customize the to string method
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + ", pf="
				+ pf + ", bonus=" + bonus + "]";
	}

	
}
