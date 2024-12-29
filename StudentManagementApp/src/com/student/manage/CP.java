package com.student.manage;

import java.sql.DriverManager;
import java.sql.Connection;

public class CP {
	
	static Connection conn;
	public static Connection createC() {
		try {
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create connection
			
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String username = "root";
			String password = "1029";
			//conn = DriverManager.getConnection(url, username, password);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","1029");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
