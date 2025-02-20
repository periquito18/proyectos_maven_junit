package com.endes.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "jdbc:sqlite:/home/oem/Documentos/proyectos_git/proyectos_maven_junit/EjemploBBDD/bbdd/holamundobbddt";
	private static Connection connection;

	private DatabaseConnection() {

	}

	/**
	 * Realiza la conexión a la base de datos
	 * 
	 * @return conexión a al base de datos
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws ClassNotFoundException {
		if (connection == null) {
			try {
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection(URL);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return connection;
	}

	/**
	 * Realiza la desconexión
	 */
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException ex) {

			}
		}
	}

}
