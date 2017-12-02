import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String findUserNameHas(String username) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql:///test1?user=root&password=123");

		String sql = "select username from user where username = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, username);

		ResultSet eq = pst.executeQuery();
		String name = null;
		while (eq.next()) {
			name = eq.getString("username");
		}
		if (name != null && name.length() > 0) {
			return name;
		}
		return null;
	}
}
