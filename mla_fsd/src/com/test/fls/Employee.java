package com.test.fls;

import java.io.Serializable;

public class Employee implements Serializable{
	private int id=101;
	private String name="Sam";
	private String cmp="Mphasis";
	private transient int pin=560048;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cmp=" + cmp + "]";
	}
	
	
	
}
