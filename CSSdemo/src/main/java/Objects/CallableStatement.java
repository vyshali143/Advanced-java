package Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLType;

public class CallableStatement {
public static void main(String args[], SQLType Types, String FLOAT) throws SQLException, ClassNotFoundException  {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vyshali","welcome");
	//call the procedure
			java.sql.CallableStatement callableStatement=connection.prepareCall("{call getSal(?,?)}");
	//set the input data.
	callableStatement.setInt(1, 1002);
	//register one variable to store the output
	callableStatement.registerOutParameter(2,Types,FLOAT);
	//execute the procedure th output will be stored in registered parameter
	callableStatement.executeUpdate();
	//print the output
	System.out.println(callableStatement.getFloat(2));
	connection.close();

}
}
