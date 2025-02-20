package com.endes.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.endes.bbdd.DatabaseConnection;

public class ProductDAO {
	
	
	
	public void crearTabla() throws ClassNotFoundException {
		String sql = "CREATE TABLE product (id INTEGER PRIMARY KEY, name TEXT NOT NULL, price DOUBLE NOT NULL);";
		try{
			Connection conn = DatabaseConnection.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		}catch(SQLException ex) {
			System.out.println(ex.toString());
		}
		
	}

}
