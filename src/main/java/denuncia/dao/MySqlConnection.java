package denuncia.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto","root", "303030");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
