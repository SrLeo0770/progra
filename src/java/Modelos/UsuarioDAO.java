/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método para validar usuario
    public Usuario validarUsuario(String correo, String password) {
        Usuario usuario = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM usuario WHERE correo = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, correo);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("idusuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("roll")
                );
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    // Método para registrar usuario
    public void registrarUsuario(Usuario usuario) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO usuario (nombre, correo, password, roll) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getRoll());
            stmt.executeUpdate();

            // Obtener el ID del nuevo usuario y registrar en el historial
            stmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int nuevoId = rs.getInt(1);
                registrarHistorial(nuevoId);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para registrar historial
    public void registrarHistorial(int idUsuario) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO historial_usuarios (id_usuario) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para obtener historial
    public List<Usuario> getHistorial() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT u.idusuario, u.nombre, u.correo, u.telefono, u.roll " +
                           "FROM usuario u " +
                           "JOIN historial_usuarios h ON u.idusuario = h.id_usuario";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("idusuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("roll")
                );
                usuarios.add(usuario);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
