package com.bridgelabz.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreImageInDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {

		// Step1: Register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step2: Create Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details", "root",
				"password");

		// Step3: Create Statement
		PreparedStatement statement = connection.prepareStatement("update employee set ProfilePic=? where eid=1");
		FileInputStream file = new FileInputStream("/home/admin1/Downloads/deep.jpeg");
		statement.setBinaryStream(1, file);

		// Step4: Execute Query

		statement.executeUpdate();
		statement.close();

		// Step5: Close connection
		connection.close();
	}

}
