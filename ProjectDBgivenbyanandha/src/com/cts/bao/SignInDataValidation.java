package com.cts.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cts.vo.LoginVO;

public class SignInDataValidation {

	/**
	 * @param e
	 * @return DB validation for sign-in and insertion into DB
	 */
	public boolean validate(LoginVO e) {
		String id = e.getName();
		String pass = e.getPassword();

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
				stmt = conn.createStatement();
				String stmt2 = ("SELECT * FROM demo2 WHERE Password=('" + pass + "')");
				final PreparedStatement ps2 = conn.prepareStatement(stmt2);
				final ResultSet resultSet2 = ps2.executeQuery();
				if (resultSet2.next()) {
					return true;
				} else {
					return false;
				}
			} else {

				return false;
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
