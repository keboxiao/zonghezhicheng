package com.connectdb;

import java.sql.*;

public class Mydbbean {
	Connection con = null;
	private static final String DRIVER_NAME = "org.gjt.mm.mysql.Driver";

	public Mydbbean() {
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection("jdbc:mysql://132.102.104.132:3306/boke_yydz_test?useUnicode=true&characterEncoding=GB2312",
					"root", "Navicat2014");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public ResultSet executeQuery(String sql) {

		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}

	public boolean executeUpdate(String sql) {

		PreparedStatement pstm = null;
		boolean b = false;
		try {
			pstm = con.prepareStatement(sql);
			pstm.executeUpdate();
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	public void close(Connection con, Statement stmt) {
		try {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}