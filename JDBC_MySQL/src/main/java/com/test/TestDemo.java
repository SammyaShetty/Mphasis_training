package com.test;

import java.util.List;

public class TestDemo {
	
	public static void main(String[] args) {
		 
		EmpDao edao=new EmpDao();
		Employee emp1=new Employee();
		emp1.setId(3);
		emp1.setName("Gopu");
		emp1.setCmp("Deloite");
		emp1.setCity("Chennai");
		
		//edao.saveEmployee(emp1); //(add)
		//edao.updateEmployee(emp1); //update
		//edao.deleteEmployee(3);    //delete
		System.out.println("Updated Employee data.");
		
		List<Employee> data=edao.getAllEmployees();
		data.forEach(System.out::println);
	}
}