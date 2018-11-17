package odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

	private Connection con;

	public DataSource() {

	}

	public ResultSet execute(String query) {
		ResultSet rs = null;
		this.open();

		try {
			Statement st = this.con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	private void open() {
		if (con == null) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:DBodbc");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
