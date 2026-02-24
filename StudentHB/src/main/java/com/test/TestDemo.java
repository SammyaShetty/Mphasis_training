package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDemo {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		College c1=new College();
		c1.setC_name("MLA");
		Student s1=new Student();
		s1.setC_name("Sam");
		s1.setS_type("MCA");
		s1.setS_branch("Software");
		
		Faculty f1=new Faculty();
		f1.setC_name("Arjun");
		f1.setF_type("Regular");
		f1.setF_skill("Admin");
		s.persist(c1);
		s.persist(s1);
		s.persist(f1);
		t.commit();
		s.close();
	}
}
