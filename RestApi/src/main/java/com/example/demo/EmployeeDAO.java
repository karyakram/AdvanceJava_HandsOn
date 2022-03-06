package com.example.demo;

import org.springframework.stereotype.Repository;

import com.example.demo.Employees;

@Repository

public class EmployeeDAO {

	private static Employees list= new Employees();

	static
	{

		list.getEmployeeList().add(
				new Employee(1,"Lionel","Messi","leomessi10@gmail.com"));

		list.getEmployeeList().add(
				new Employee(2, "Sergio", "Aguero", "abc@gmail.com"));

		list.getEmployeeList().add(
				new Employee( 3, "David","Silva","asdjf@gmail.com"));

	}

	public Employees getAllEmployees(){
		return list;
	}

	public void addEmployee(Employee employee){
		list.getEmployeeList().add(employee);    
	}

}
