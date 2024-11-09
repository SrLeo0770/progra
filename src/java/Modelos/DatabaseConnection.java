/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Lester
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Cambia estos valores a los que correspondan a tu base de datos MySQL
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Transporte"; // Cambia "tu_base_de_datos" por el nombre de tu base de datos
    private static final String JDBC_USER = "root"; // Cambia "root" por tu usuario de MySQL
    private static final String JDBC_PASS = ""; // Cambia "password" por tu contraseña de MySQL

    private static Connection connection;

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Cargar el controlador JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Establecer la conexión a la base de datos
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new SQLException("Error al conectar a la base de datos.");
            }
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
