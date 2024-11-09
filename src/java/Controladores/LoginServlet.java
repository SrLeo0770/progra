/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */



import de.svws_nrw.ext.jbcrypt.BCrypt;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Transporte";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";

    private static final String SELECT_USER_SQL = "SELECT * FROM usuario WHERE correo = ?";

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);
            preparedStatement.setString(1, correo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                String storedRoll = resultSet.getString("roll");

                // Compara la contraseña ingresada con la almacenada usando bcrypt
                if (BCrypt.checkpw(password, storedPassword)) {
                    // Contraseña correcta, autenticar al usuario
                    HttpSession session = request.getSession();
                    session.setAttribute("nombre", resultSet.getString("nombre"));
                    session.setAttribute("roll", storedRoll);

                    if (storedRoll.equals("admin")) {
                        response.sendRedirect("adminDashboard.jsp");
                    } else {
                        response.sendRedirect("userDashboard.jsp");
                    }
                } else {
                    // Contraseña incorrecta
                    response.sendRedirect("login.jsp?error=true");
                }
            } else {
                // Usuario no encontrado
                response.sendRedirect("login.jsp?error=true");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=exception");
        }
    }
}


