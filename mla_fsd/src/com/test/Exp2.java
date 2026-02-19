package com.test;
@FunctionalInterface
// fi can have only 1 abstract method 
interface FunInf
{
	void draw();        
	//void color(); error coz 2nd abst meth
	default void dog()
	{
		
	}
	
	static void cat()
	{
		
	}
}

class Circle implements FunInf
{
	@Override
	public void draw(){
		System.out.println("circle");
	}
}

class Square implements FunInf
{
	@Override
	public void draw() {
		System.out.println("square");
	}
	
	//factory method 
	public Square getObj()
	{
		System.out.println("object returned");
		return new Square();
		
	}
}
public class Exp2 {
	public static void main(String[] args) {
		
		Circle obj1=new Circle();
		obj1.draw();
		
		Square obj2=new Square();
		obj2.draw();
		
		//Square obj3=obj2.getObj();
		
		//lambda expression syntax [instead of typing full code this one line works the same]
		FunInf obj3= () -> System.out.println("circle");
		obj3.draw();
	}
}
