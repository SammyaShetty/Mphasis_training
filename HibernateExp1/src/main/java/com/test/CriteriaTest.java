package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaTest {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		CriteriaBuilder cb=s.getCriteriaBuilder();
		CriteriaQuery<Customer> cq=cb.createQuery(Customer.class);
		cq.distinct(true);
		Root<Customer> rt=cq.from(Customer.class);
		cq.select(rt);
		TypedQuery<Customer> tq=s.createQuery(cq);
		List<Customer> list=tq.getResultList();
		System.out.println(list);
	
	}
	
}
