
package Controladores;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrarTransporte")
public class RegistrarTransporte extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/transporte";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";

    private static final String INSERT_USER_SQL = 
        "INSERT INTO transporte (nombre_trasporte, nombre_contacto,telefono_contacto,correo_contacto) VALUES (?, ?, ?, ?)";

    public RegistrarTransporte() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String contacto = request.getParameter("contacto");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
       

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, contacto);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            
            int result = preparedStatement.executeUpdate();
            
            if (result > 0) {
                response.sendRedirect("adminDashboard.jsp?success=registered");
            } else {
                response.sendRedirect("agregarTransporte.jsp?error=registrationFailed");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=exception");
        }
    }

}