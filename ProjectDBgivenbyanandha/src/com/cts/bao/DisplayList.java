package com.cts.bao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cts.vo.LoginVO;

public class DisplayList {
	/**
	 * @return Display of data's from DB
	 */
	public ArrayList display() {
		LoginVO o = new LoginVO();
		ArrayList pat = new ArrayList();
		String s = o.getName();
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
			String query = "select * from demo1 WHERE Id=('" + s + "')";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery(query);
			System.out.println("Inserted records into the table...");
			if (rs.next() == false) {
				System.out.println("No Data");
				pat.add("No test registered");

			} else {
				System.out.println("data");

				pat.add(rs.getObject("Id"));
				pat.add(rs.getObject("Date"));
				pat.add(rs.getObject("Place"));
				pat.add(rs.getObject("Slot"));
				pat.add(rs.getObject("Level"));
			}
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
		return pat;

	}
}
