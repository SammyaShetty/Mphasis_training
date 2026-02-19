package com.text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemo {
	public static Connection getDBcon() {
		Connection con=null;
		try {
			String url="jdbc:mysql://localhost:3306/mlafeb";
			
			String user="root";
			String pas="root@39";
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(url,user,pas);
		}catch(Exception e) {
			e.fillInStackTrace();
		}
		return con;
		
		
		
//		Connection con=DriverManager.getConnection(url,user,pas);
//		
//		Statement stmt=con.createStatement();
//		String sql="create table user101(fullname varchar(50),username varchar(50),password varchar(50))";
//		stmt.execute(sql);
//		con.close();
//		System.out.println("Done.");
//		
	}
}
