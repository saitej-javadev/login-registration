package com.saitej.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class DBUtil {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		System.out.println("DBUtil.getConnection()");
		Connection con = null;
		try {
			// Load the driver class
			Class.forName(DRIVER);
			// Create the connection
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return con;

	}

}
