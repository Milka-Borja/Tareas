package Tarea_Banco_BDD.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/banco_db";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";

    // Metodo estático para obtener la conexión
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Establece la conexión
            conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos. ¿Está MySQL corriendo? " + e.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}