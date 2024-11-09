/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */package Controladores;

import java.sql.DriverManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/TransportesJSONServlet")
public class TransportesJSONServlet extends HttpServlet {
    
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/transporte";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONArray jsonArray = new JSONArray();

        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            String query = "SELECT idtransporte, nombre_trasporte FROM transporte.transporte";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("idtransporte", rs.getInt("idtransporte"));
                jsonObject.put("nombre", rs.getString("nombre_trasporte"));
                jsonArray.put(jsonObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.print(jsonArray.toString());
        out.flush();
    }
}