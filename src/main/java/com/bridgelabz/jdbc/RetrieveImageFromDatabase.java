package com.bridgelabz.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveImageFromDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		// Step1: Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step2: Create Connection

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details", "root",
				"password");

		// Step3: Create Statement

		Statement statement = connection.createStatement();

		// Step4: Exceute query

		ResultSet result = statement.executeQuery("select ProfilePic from employee where eid=1");
		Blob blob = null;
		if (result.next())
			blob = result.getBlob(1);

		byte barr[] = blob.getBytes(1, (int) blob.length());

		FileOutputStream fout = new FileOutputStream("/home/admin1/Desktop/image_read_from_db.jpeg");
		fout.write(barr);
		fout.close();
		connection.close();

	}

}
