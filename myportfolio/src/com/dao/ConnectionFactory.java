package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static String url="jdbc:mysql://localhost:3306/myportfolio";
	private static String username="root";
	private static String password="root";
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static Connection con;

	public static Connection getConnection() 
	{
		try {
			
			
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,username,password);
			//System.out.println(" CONNECTION DONE");
			
		}
		catch (Exception e) {
			System.out.println(e);
			//e.printStackTrace();
		}
		return con;
	}
}