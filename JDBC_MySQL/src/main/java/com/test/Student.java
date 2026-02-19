package com.test;

public class Student {
	private int usn;
	private String name;
	private String dept;
	private String clg;
	public int getUsn() {
		return usn;
	}
	public void setUsn(int usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getClg() {
		return clg;
	}
	public void setClg(String clg) {
		this.clg = clg;
	}
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", name=" + name + ", dept=" + dept + ", clg=" + clg + "]";
	}
	
}
