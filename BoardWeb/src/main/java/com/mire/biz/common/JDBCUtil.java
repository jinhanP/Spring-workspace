package com.mire.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//공통으로 쓰는 곳
public class JDBCUtil {
	public static Connection getConnection() {
		try {
			//h2 접속 
//			Class.forName("org.h2.Driver");
//			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			//oracle 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}

		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
