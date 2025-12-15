📑 Simulador Bancario Interactivo (Java Swing + MySQL)
📌 Resumen del Proyecto
Este proyecto implementa un sistema bancario interactivo desarrollado en Java Swing para la interfaz gráfica. Su funcionalidad principal es la persistencia de datos (credenciales, saldos y operaciones) a través de una base de datos MySQL, utilizando JDBC (Java Database Connectivity) para la comunicación.

El sistema permite:

Registro de Nuevos Usuarios con un saldo inicial.

Inicio de Sesión con validación de credenciales y bloqueo por intentos fallidos.

Operaciones Bancarias: Depósito, Retiro y Transferencia.

Actualización Inmediata del saldo en la interfaz y en la base de datos después de cada transacción.

🛠️ Configuración de la Base de Datos
El sistema utiliza una tabla llamada usuarios para almacenar toda la información del cliente.

SQL (MySQL) Requerido
SQL

CREATE DATABASE IF NOT EXISTS banco_bdd;
USE banco_bdd;

CREATE TABLE usuarios (
    usuario VARCHAR(50) PRIMARY KEY,
    clave VARCHAR(255) NOT NULL,
    nombre_cliente VARCHAR(100) NOT NULL,
    saldo DECIMAL(10, 2) DEFAULT 0.00
);

-- Ejemplo de usuario para prueba inicial
INSERT INTO usuarios (usuario, clave, nombre_cliente, saldo) 
VALUES ('cliente123', 'clave123', 'Juan Pérez', 1000.00);
Clase de Conexión Centralizada (ConexionDB.java)
Esta clase centraliza los parámetros de conexión para ser reutilizados en todo el proyecto, cumpliendo el requisito de no repetir credenciales.

Java

package Tarea_Banco_BDD.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/banco_bdd";
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 

    public static Connection getConnection() {
        // ... (Lógica para establecer la conexión y manejo de SQLException)
    }

    public static void closeConnection(Connection conn) {
        // ... (Lógica para cerrar la conexión de forma segura)
    }
}
Capturas de Ejecucion:
Pagina principal:
<img width="988" height="729" alt="image" src="https://github.com/user-attachments/assets/7ba06fe1-2fb3-4cad-9d56-13fe7ae99a96" />
Pagina de registro:
<img width="988" height="736" alt="image" src="https://github.com/user-attachments/assets/40a49b81-79dc-4921-928a-72ad6b918d02" />
<img width="692" height="398" alt="image" src="https://github.com/user-attachments/assets/ac4613b7-9fa7-405a-8fb2-99ca2a73c546" />
<img width="697" height="394" alt="image" src="https://github.com/user-attachments/assets/90b5e3ca-571e-4a2a-ae89-61c41065a93d" />
<img width="583" height="508" alt="image" src="https://github.com/user-attachments/assets/81838fd0-de43-452c-9426-f545a1074239" />
Visualizacion de los datos ingresados en la base de datos:
<img width="880" height="547" alt="image" src="https://github.com/user-attachments/assets/e83f485e-9024-475f-ad28-05f880372407" />
<img width="950" height="682" alt="image" src="https://github.com/user-attachments/assets/1ad5a244-640d-4e96-b34e-6f5fc0930f6e" />
