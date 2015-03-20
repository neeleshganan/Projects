package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getConnection()
	{
		String jdbcURL = "jdbc:oracle:thin:@192.168.129.12:1521:orcl";

		String username = "a07e";
		String password ="a07e";
		
		Connection conn=null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("class not found please set path for class");
		}
		try 
		{
			conn = DriverManager.getConnection(jdbcURL,username,password);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
}
