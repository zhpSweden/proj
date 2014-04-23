package us.ucsd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.enterprise.inject.Instance;

public final class JDBCUtils {
	private static String url = "jdbc:postgresql://localhost:5432/demo";
	private static String user = "postgres";
	private static String password = "123456";
	
	private static JDBCUtils instance = null;
	private JDBCUtils(){
		
	}
	public static JDBCUtils getInstance() {
		if(instance == null) {
			synchronized (JDBCUtils.class) {
				if(instance == null) {
					instance = new JDBCUtils();
				}
			}
		}
		return instance;
	}
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public void free(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			try {
				if(st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
		}
	}
}
