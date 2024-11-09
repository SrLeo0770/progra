/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Lester
 */

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String telefono;
    private String roll; // "administrador" o "usuario"
    private String contrasena;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(int idUsuario, String nombre, String correo, String telefono, String roll) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.roll = roll;
    }

    public Usuario(String nombre, String correo, String password, String roll) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getContrasena() {
       return contrasena;
   }
   
    public void setContrasena(String roll) {
        this.contrasena = contrasena;
    }

}
