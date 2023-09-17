package com.trungtamjava.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
public static Connection getJDBCConnection() {
	final String url = "jdbc:mysql://127.0.0.1:3306/BAN_HANG";
	final String user ="root";
	final String password="123456";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	catch (SQLException e) {
		e.printStackTrace();
		}
	return null;
}
}
