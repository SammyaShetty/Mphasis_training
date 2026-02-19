package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public static Connection getCon() {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mlafeb";
		String user="root";
		String pas="root@39";
		
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pas);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void saveStudent(Student s)
	{
		try {
			String sql="insert into student(usn, name, dept,clg) values(?,?,?,?)";
			Connection con=StudentDao.getCon();
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, s.getUsn());
			pst.setString(2, s.getName());
			pst.setString(3, s.getDept());
			pst.setString(4, s.getClg());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudent() {
		List<Student> Slist=new ArrayList<>();
		
		try {
			String sql="select * from student";
			PreparedStatement pst=StudentDao.getCon().prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Student std=new Student();
				std.setUsn(rs.getInt(1));
				std.setName(rs.getString(2));
				std.setDept(rs.getString(3));
				std.setClg(rs.getString(4));
				
				Slist.add(std);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Slist;
	}
	
	public void updateStud(Student s) {
		try {
			String sql="update student set name=?,dept=?,clg=? where usn=?";
			PreparedStatement pst=StudentDao.getCon().prepareStatement(sql);
			pst.setString(1, s.getName());
			pst.setString(2, s.getDept());
			pst.setString(3, s.getClg());
			pst.setInt(4, s.getUsn());
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteStud(int usn) {
		try {
			String sql="delete from student where usn=?";
			PreparedStatement pst=StudentDao.getCon().prepareStatement(sql);
			pst.setInt(1, usn);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
}
