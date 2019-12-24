package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		try {
			// Step1: Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2: Create Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details", "root",
					"password");

			// Step3: Create Statement
			statement = connection.createStatement();

			// Step4 : Execute Query
			ResultSet result = statement.executeQuery("Select * from employee");
			while (result.next()) {
				System.out.println("EID: " + result.getInt(1) + " ENAME: " + result.getString(2) + " SALARY :"
						+ result.getDouble(3) + " AGE: " + result.getInt(4));
			}
		} catch (Exception e) {
			System.out.println("Failed to connect to database....");
		} finally {

			statement.close();

			// Step:5 Close Connection
			connection.close();
		}

	}

}
