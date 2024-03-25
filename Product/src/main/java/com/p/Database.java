package  com.p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	public static Connection createConnection1() {
		Connection connect=null;
		PreparedStatement pps=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connect=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vyshali","welcome");
			pps= connect.prepareStatement("select * from product where id=?");
		}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
			return connect;
	}
}

