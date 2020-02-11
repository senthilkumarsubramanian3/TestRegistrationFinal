package com.cts.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cts.vo.LoginVO;

/**
 * @author 765584 Name fetch from DB to display in the Home page
 */
public class SignInNameFetch {

	public String fetch(LoginVO e) {
		String id = e.getName();
		String name = null;
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
			String stmt1 = ("select * from demo2 WHERE Id=('" + id + "')");
			final PreparedStatement ps = conn.prepareStatement(stmt1);
			final ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			name = resultSet.getString(2);
		} catch (SQLException se) {
			se.printStackTrace();

		} catch (Exception e1) {
			e1.printStackTrace();

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

		return name;
	}

}
