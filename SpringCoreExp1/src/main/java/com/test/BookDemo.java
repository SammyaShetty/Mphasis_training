package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookDemo {
	public static void main(String[] args) {
	//XML Config
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
//		Book b=(Book)ctx.getBean("bk");
//		System.out.println(b);
		
		//Anootation Config
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AnnoConfig.class);
		BookDetails b1=ctx.getBean(BookDetails.class);
		Book b2=ctx.getBean(Book.class);
		b1.setPages(250);
		b1.setPublisher("MLA");
		b1.setPyear(2023);

		List<BookDetails> list=new ArrayList<>();
		list.add(b1);
		b2.setId(201);
		b2.setName("python");
		b2.setAuthor("Skyward");
		b2.setPrice(250);
		b2.setListbd(list);
		
		System.out.println(b2);
	}
}
