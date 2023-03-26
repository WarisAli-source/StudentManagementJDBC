 package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	static Connection con;
	
	public static Connection createC() {
		try {
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			
			String user = "root";
			String password = "password";
			String url = "jdbc:mysql://localhost:3307/myDatabase";
			con = DriverManager.getConnection(url,user,password);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
