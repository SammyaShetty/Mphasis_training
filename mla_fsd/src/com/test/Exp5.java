package com.test;

public class Exp5 {
	public static void main(String[] args) {
		try {
			System.out.println(10/0);
		}
		catch(Exception e) {
			//getMessage()
			System.out.println(e.getMessage());
			
			//printing exception class object
			System.out.println(e);
			
			//printStackTrace()
			e.printStackTrace();
		}
	}
}

/*OUTPUT
 * / by zero
 * java.lang.ArithmeticException: / by zero
 * java.lang.ArithmeticException: / by zero
 * 			at com.test.Exp5.main(Exp5.java:6)
 */
