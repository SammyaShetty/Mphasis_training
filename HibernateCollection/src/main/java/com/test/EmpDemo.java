package com.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;

public class EmpDemo {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		List<String> s1= Arrays.asList("Java","Cloud","DevOps");
		List<String> s2=Arrays.asList("php","python","ASE");
		Employee emp1=new Employee();
		emp1.setE_name("Sam");
		emp1.setSkills(s1);
		
		Employee emp2=new Employee();
		emp2.setE_name("ABC");
		emp2.setSkills(s2);
		s.persist(emp1);
		s.persist(emp2);
		t.commit();
		TypedQuery<Employee> tq=s.createQuery("from Employee");
		List<Employee> list=tq.getResultList();
		Iterator<Employee> itr=list.iterator();
		while (itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println("Employee: "+emp.getE_name());
			List<String> skills=emp.getSkills();
			skills.forEach(System.out::println);
			
		}
		
		s.close();
	}
}
