/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Alumno;


public class AlumnoController {
    public void insert(Alumno alumno) throws SQLException {
        String query = "";
        Conexion db = new Conexion();

        query = "INSERT INTO alumno VALUES (?,?,?,?,?,?);";
        
        PreparedStatement ps = db.conectar().prepareStatement(query);
        ps.setString(1, alumno.getDni());
        ps.setString(2, alumno.getNombre());
        ps.setString(3, alumno.getApellidos());
        ps.setString(4, alumno.getDireccion());
        ps.setString(5, alumno.getEmail());
        ps.setString(6, alumno.getTelefono());

        if (ps.executeUpdate() > 0) {
            System.out.println("El registro se insertó exitosamente.");
        } else {
            System.out.println("No se pudo insertar el registro.");
        }

        ps.close();
        db.conexion.close();
    }

    public void getAlumnoByDni(String dni) {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "SELECT * FROM alumno WHERE dni_alumno = ?;";
            PreparedStatement ps = db.conectar().prepareStatement(query);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString("nombre_alumno");
                String apellidos = rs.getString("apellidos_alumno");
                String direccion = rs.getString("direccion_alumno");
                String email = rs.getString("email_alumno");
                String telefono = rs.getString("telefono_alumno");

                // Imprimir los resultados.
                System.out.format("%s,%s,%s,%s,%s\n", nombre, apellidos, direccion, email, telefono);

            }

            ps.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllAlumnos() {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "SELECT * FROM alumno;";
            Statement stm = db.conectar().createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {

                String dni = rs.getString("dni_alumno"); //Aqui va el campo de la db
                String nombre = rs.getString("nombre_alumno");
                String apellidos = rs.getString("apellidos_alumno");
                String direccion = rs.getString("direccion_alumno");
                String email = rs.getString("email_alumno");
                String telefono = rs.getString("telefono_alumno");
 
                // Imprimir los resultados.
                System.out.format("%s,%s,%s,%s,%s,%s\n", dni, nombre, apellidos, direccion, email, telefono);

            }

            stm.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update_email(String dni, String str) {
        String query = "";
        Conexion bd = new Conexion();

        try {
            query = "UPDATE alumno SET email_alumno = ? WHERE dni_alumno = ?;";
            PreparedStatement ps = bd.conectar().prepareStatement(query);
            ps.setString(1, str);
            ps.setString(2, dni);

            ps.executeUpdate();
            System.out.println("El registro se actualizó exitosamente.");
            ps.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String dni) {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "DELETE FROM alumno WHERE dni_alumno = ?;";
            PreparedStatement ps = db.conectar().prepareStatement(query);
            ps.setString(1, dni);

            ps.execute();
            System.out.println("El registro se eliminó exitosamente.");
            ps.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
