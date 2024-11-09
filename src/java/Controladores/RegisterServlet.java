/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;


import de.svws_nrw.ext.jbcrypt.BCrypt;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Transporte";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";

    private static final String INSERT_USER_SQL = "INSERT INTO usuario (nombre, correo, telefono, password, roll) VALUES (?, ?, ?, ?, ?)";

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String password = request.getParameter("password");
        String roll = request.getParameter("roll");

        try {
            // Hash de la contraseña usando bcrypt antes de guardarla
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, correo);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, hashedPassword); // Guardamos la contraseña encriptada con bcrypt
            preparedStatement.setString(5, roll);

            int result = preparedStatement.executeUpdate();
            
            if (result > 0) {
                response.sendRedirect("login.jsp?success=registered");
            } else {
                response.sendRedirect("register.jsp?error=registrationFailed");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=exception");
        }
    }
}





