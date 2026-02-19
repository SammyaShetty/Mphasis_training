package com.test;

import java.util.List;

public class TestStud {
	public static void main(String[] args) {
		StudentDao sdao=new StudentDao();
		Student s1=new Student();
		s1.setUsn(2);
		s1.setName("xyz");
		s1.setDept("MCA");
		s1.setClg("Christ");
		
		//sdao.saveStudent(s1);
		//sdao.updateStud(s1);
		sdao.deleteStud(1);
		System.out.println("Saved Student details");
		
		List<Student> data=sdao.getAllStudent();
		data.forEach(System.out::println);
	}
}
