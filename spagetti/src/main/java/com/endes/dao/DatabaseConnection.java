package com.endes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton para la conexión a la base de datos SQLite (sin uso de logs).
 */
public class DatabaseConnection {

    // URL de la BBDD (adáptala a tu ruta real)
    private static final String URL = "jdbc:sqlite:/home/kronos/Documentos/bbdd/mi_primera_bbdd";

    // Instancia única de esta clase
    private static DatabaseConnection instance;

    // Objeto Connection que utilizaremos en toda la aplicación
    private Connection connection;

    /**
     * Retorna la instancia única de DatabaseConnection (Singleton).
     *
     * @return Instancia de DatabaseConnection.
     */
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private DatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(URL);
            System.out.println("Conexión establecida con la base de datos en: " + URL);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    /**
     * Devuelve el objeto Connection.
     * @return Connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Cierra la conexión si está abierta.
     */
    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
                instance = null; // Para permitir reconexión futura si fuera necesario
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}
