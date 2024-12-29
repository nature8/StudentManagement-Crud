package com.student.manage;

import com.student.manage.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDao {
	
	
	public static boolean insertStudent(Student student) {
		boolean f=false;
		try {
			Connection conn = CP.createC();
			String q = "INSERT into students(sname, sphone, scity) values(?,?,?)";
			
			//PreparedStatement st = conn.prepareStatement("INSERT into students(sname, sphone, scity) values(?,?,?)");
			PreparedStatement st = conn.prepareStatement(q);
			
			st.setString(1, student.getStudentName());
			st.setString(2, student.getStudentPhone());
			st.setString(3, student.getStudentCity());
			
			st.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static boolean deleteRecord(int userid) {
		boolean f = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","1029");
			String deleteQuery = "DELETE FROM students where sid=?";
			PreparedStatement st1 = conn.prepareStatement(deleteQuery);
			st1.setInt(1, userid);
			
			st1.executeUpdate();
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static void selectAll() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "1029");
			//PreparedStatement st = conn.prepareStatement("SELECT * FROM students");
			//st.executeQuery();
			
			String q = "SELECT * FROM students";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			
			while(rs.next()) {
				int sid = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String city = rs.getString("scity");
				
				System.out.println("Id: "+sid);
				System.out.println("Student Name: "+name);
				System.out.println("Contact Number: "+phone);
				System.out.println("City: "+city);
				System.out.println("-------------------------------------------------------");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void specificRecord(int sid) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "1029");
			String q = "SELECT * FROM students WHERE sid=?";
			
			PreparedStatement stmt = conn.prepareStatement(q);
			stmt.setInt(1, sid);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				int sid1 = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String city = rs.getString("scity");
				
				System.out.println("Id: "+sid);
				System.out.println("Student Name: "+name);
				System.out.println("Contact Number: "+phone);
				System.out.println("City: "+city);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean updateName(int sid, String newName) {
		boolean f = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","1029");
			PreparedStatement st = conn.prepareStatement("UPDATE students SET sname=? WHERE sid=?");
			st.setString(1, newName);
			st.setInt(2, sid);
			
			int rowsAffected = st.executeUpdate();

		        if (rowsAffected > 0) {
		            f = true;
		        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public static boolean updateContact(int sid, String newContact) {
		boolean f = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","1029");
			PreparedStatement st = conn.prepareStatement("UPDATE students SET sphone=? WHERE sid=?");
			st.setString(1, newContact);
			st.setInt(2, sid);
			
			int rowsAffected = st.executeUpdate();

		        if (rowsAffected > 0) {
		            f = true;
		        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public static boolean updateCity(int sid, String newCity) {
		boolean f = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","1029");
			PreparedStatement st = conn.prepareStatement("UPDATE students SET scity=? WHERE sid=?");
			st.setString(1, newCity);
			st.setInt(2, sid);
			
			int rowsAffected = st.executeUpdate();

		        if (rowsAffected > 0) {
		            f = true;
		        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
