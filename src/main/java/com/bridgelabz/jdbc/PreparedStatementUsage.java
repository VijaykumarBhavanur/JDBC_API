package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUsage {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			// Step1: Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2: Create Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details", "root",
					"password");

			// Step3: Create Statement
			statement = connection.prepareStatement("select * from employee where eid=?");
			System.out.println("Enter employee id to fetch record::");
			Scanner scn = new Scanner(System.in);
			int eid = scn.nextInt();
			statement.setInt(1, eid);
			result = statement.executeQuery();
			int col_count=result.getMetaData().getColumnCount();
			System.out.println("Number of columns:::::"+col_count);
			System.out.println("List of column names:");
			int i=1;
			while(i<=col_count)
			{
				System.out.println(result.getMetaData().getColumnName(i));
				i++;
			}
			while (result.next())
				System.out.println("EID: " + result.getInt(1) + "  ENAME: " + result.getString(2) + " ESALARY: "
						+ result.getDouble(3) + " EAGE: " + result.getInt(4));

		} catch (Exception e) {
			System.out.println("Failed to connect to database....");
			e.printStackTrace();
		} finally {
			result.close();
			statement.close();
			connection.close();
		}
	}

}
