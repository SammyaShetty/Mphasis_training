package com.test;

public class Exp4 {
	
	public static void main(String[] args) {
		System.out.println("MLA");
		System.out.println(11/2);
		System.out.println("coders");
		String name="sam";
		System.out.println(name.charAt(1));
		int[] arr= {2,4,5,6,6};
		System.out.println(arr[5]);
		int x= Integer.parseInt("22a3");
		//Class.forName("");
		try {
			System.out.println(11/5);
			String name1=null;
			System.out.println(name.equals("test"));
			
		}
		catch(ArithmeticException e){
			System.out.println("cant divide by zero");
		}
		catch(NullPointerException npe){
			System.out.println("enter value for string");
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("check  string length");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("check array length");
		}
		catch(Exception e) {
			System.out.println("try again");
		}
		finally {
			System.out.println("Finally block");
		}
	}

}
