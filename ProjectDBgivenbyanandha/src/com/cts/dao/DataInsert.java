package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cts.vo.BookDetailsVO;
import com.cts.vo.LoginVO;

/**
 * @author 765584 Insertion of data's in DB
 */
public class DataInsert {
	public boolean insertIntoDB(BookDetailsVO o) {
		LoginVO o1 = new LoginVO();
		String loginname = o1.getName();
		String name = o1.getName();
		String date = o.getDate();
		String slot = o.getSlot();
		String level = o.getLevel();
		String place = o.getPlace();
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
			if (loginname.equals(name)) {
				String stmt1 = ("select * from demo1 WHERE Id=('" + name + "')");
				final PreparedStatement ps = conn.prepareStatement(stmt1);
				final ResultSet resultSet = ps.executeQuery();
				if (resultSet.next()) {
					return false;
				} else {
					stmt = conn.createStatement();
					String query = "INSERT INTO `demo1` (Id,Date,Place,Slot,Level) VALUE (?,?,?,?,?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString(1, name);
					preparedStmt.setString(2, date);
					preparedStmt.setString(3, place);
					preparedStmt.setString(4, slot);
					preparedStmt.setString(5, level);
					preparedStmt.executeUpdate();
					System.out.println("Inserted records into the table...");
					return true;
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
