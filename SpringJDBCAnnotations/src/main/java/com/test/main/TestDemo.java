package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.FruitsDao;
import com.test.model.Fruits;

public class TestDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		
		FruitsDao dao=ctx.getBean(FruitsDao.class);
		Fruits fu=new Fruits();
		fu.setId(101);
		fu.setName("Apple");
		fu.setPrice(150);
		fu.setQuantity(5);
		
		dao.saveFruits(fu);
		
		List<Fruits> list=dao.getAllFruits();
		list.forEach(System.out::println);
	}
}
