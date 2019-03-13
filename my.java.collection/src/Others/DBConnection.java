package src.Others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//https://www.javatpoint.com/example-to-connect-to-the-mysql-database
public class DBConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Here we load the driver’s class file into memory at the runtime.
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");
		// here sonoo is database name, root is username and password
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from emp");
		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		con.close();
	}
}
