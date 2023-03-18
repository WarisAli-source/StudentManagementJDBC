package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertIntoDB(Student st) {
		
		boolean flag = false;
		try {
			//connection creation
			
			Connection con = ConnectionProvider.createC();
			
			//query
			String q = "insert into students(sname,sphone,scity) values (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			//insert 
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			pstmt.executeUpdate();
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return flag;
	}

	public static boolean deleteStudent(int userId) {

		boolean flag = false;
		try {
			//connection creation
			
			Connection con = ConnectionProvider.createC();
			
			//query
			String q = "delete from students where sid=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setInt(1, userId);

			pstmt.executeUpdate();
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return flag;
		
	}
	public static void showAllStudent() {

		try {
			//connection creation
			
			Connection con = ConnectionProvider.createC();
			
			//query
			String q = "select * from students;";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);

				String city = set.getString("scity");
				System.out.println("ID :"+id);
				System.out.println("Name :"+name);
				System.out.println("Phone: "+phone);
				System.out.println("City: "+city);
				
				System.out.println("----------------------------");

				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	
	
}
