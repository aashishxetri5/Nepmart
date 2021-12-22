/**
 * 
 */
package com.org.nepmart.utility;

/**
 * @author Aashish Katwal
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	Connection con;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nepmart", "root", "1Enter@MYsql");
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex + " has been caught");
		}
		return con;
	}

}
