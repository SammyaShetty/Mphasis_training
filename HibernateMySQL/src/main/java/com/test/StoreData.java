package com.test;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StoreData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		
		Book obj=new Book();
		obj.setB_name("Spring");
		obj.setB_author("Samuel");
		obj.setB_price(3);

		session.persist(obj);
		
//		Book dt=session.get(Book.class, 52);
//		
//		System.out.println(dt.getId()+" "+dt.getB_name()+" "+dt.getB_author()+" "+dt.getB_price());
//		dt.setB_name("HTML");
//		dt.setB_author("abc");
//		dt.setB_price(11);
//		session.persist(dt);
//		//session.remove(dt);
		t.commit();
		Query<Book> q=session.createQuery("from Book");
		List<Book> list=q.list();
		for(Book b : list)
		{
			System.out.println(b.getId()+" "+b.getB_name()+" "+b.getB_author()+" "+b.getB_price());
		}
		System.out.println("Done.");

	}
}
