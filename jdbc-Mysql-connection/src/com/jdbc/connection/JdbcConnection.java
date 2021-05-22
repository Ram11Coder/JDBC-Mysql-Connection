package com.jdbc.connection;

import java.sql.*;

public class JdbcConnection {
	/*
	 * 1.Import the sql 2.Load and Register mysql connector from internet
	 * 2.Load and register the jar file
	 * 3.Create a connection using Driver manager
	 * 4.Create a sql statement and execute the query
	 * 5.Execute the statement
	 * 6.ResultSet now pointing to the label-Name so using rs.next 
	 *  iterate the name and print the names
	 * 7.Close the connection
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/world";
		String user = "root";
		String password = "";
		String query = "select Name from city where CountryCode =\"AFG\";";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getString("Name"));
		}

		s.close();
		con.close();
	}
}
