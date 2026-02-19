package com.test.cls;


import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;
public class Exp3 {
	public static void main(String[] args) {
		
		//TreeSet<String> data=new TreeSet<String>();
		
		
		HashSet data= new HashSet();
		data.add(200);
		data.add('a');
		data.add(33);
		data.add(200);
		data.add("java");
		data.add("test");
		data.add(33.33f);
		data.add(false);
		data.add("java");
		data.add(345l);
		System.out.println(data.size());
		System.out.println(data);
		/*
		Iterator itr=data.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		*/
		data.forEach(System.out::println);
}
}
