package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cts.vo.BookDetailsVO;
import com.cts.vo.SignUpVO;

public class DataInsertSignUp {
	/**
	 * @param o
	 * @return Insertion of datas in DB
	 */
	public boolean insertIntoDBSignup(SignUpVO o) {
		String name = o.getSignupname();
		String id = o.getSignupid();
		String pass = o.getSignuppassword();

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/Project";
		final String USER = "root";
		final String PASS = "root";
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			String stmt1 = ("SELECT * FROM demo2 WHERE Id=('" + id + "')");
			final PreparedStatement ps = conn.prepareStatement(stmt1);
			final ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {

				return false;

			} else {
				stmt = conn.createStatement();
				String query = "INSERT INTO `demo2` (Id,Name,Password) VALUE (?,?,?)";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setString(1, id);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, pass);
				preparedStmt.executeUpdate();
				System.out.println("Inserted records into the table...");
				return true;
			}

		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
