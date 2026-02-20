package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLTest {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		//String hql="select c.c_name,c.c_city from Customer c";
		String hql1="delete from Customer where c_id=:id";
		
		Query q=s.createQuery(hql1);
		q.setParameter("id", 152);
		int row=q.executeUpdate();
		
		String hql="from Customer";
		Query<Customer> dt=s.createQuery(hql);
		List<Customer> list=dt.getResultList();
		System.out.println("HQL result"+list);
//		for(Customer d:list)
//		{
//			System.out.println(d.getC_name()+" "+d.getC_city());
//		}
		t.commit();
		s.close();
	}
}
