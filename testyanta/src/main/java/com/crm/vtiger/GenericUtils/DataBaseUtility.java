package com.crm.vtiger.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
/**
 * this class contains generic methods to read data from database
 * @author SajeevKokkattil
 *
 */
public class DataBaseUtility {
	Connection con=null;
	 Resultset result=null;
	 Driver driverRef;
	
/**
 *connection with database is established
 * Author  divya
 * @throws Throwable 
 */
	public void connectDB() throws Throwable {
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename1", "root", "root");
	}
	/**
	 * DB connection is closed
	 * @ throws Throwable
	 */
	public void closeDb() throws Throwable {
		con.close();
	}
}
