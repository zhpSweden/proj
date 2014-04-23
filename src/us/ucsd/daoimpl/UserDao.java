package us.ucsd.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import us.ucsd.bean.User;
import us.ucsd.jdbc.JDBCUtils;

public class UserDao {
	public static void addUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getInstance().getConnection();
			String sql = "insert into user_t(name, role, age, state) values(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getRole());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getState());
			int res = ps.executeUpdate();
			System.out.println(res);
		} finally {
			JDBCUtils.getInstance().free(conn, ps, rs);
		}		
	} 
}
