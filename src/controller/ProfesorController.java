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
import model.Profesor;


public class ProfesorController {
    public void insert(Profesor profesor) throws SQLException {
        String query = "";
        Conexion db = new Conexion();

        query = "INSERT INTO profesor VALUES (?,?,?,?,?,?);";
        
        PreparedStatement ps = db.conectar().prepareStatement(query);
        ps.setString(1, profesor.getDni());
        ps.setString(2, profesor.getNombre());
        ps.setString(3, profesor.getApellidos());
        ps.setString(4, profesor.getDireccion());
        ps.setString(5, profesor.getEmail());
        ps.setString(6, profesor.getTelefono());

        if (ps.executeUpdate() > 0) {
            System.out.println("El registro se insertó exitosamente.");
        } else {
            System.out.println("No se pudo insertar el registro.");
        }

        ps.close();
        db.conexion.close();
    }

    public void getProfesorByDni(String dni) {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "SELECT * FROM profesor WHERE dni_profesor = ?;";
            PreparedStatement ps = db.conectar().prepareStatement(query);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString("nombre_profesor");
                String apellidos = rs.getString("apellidos_profesor");
                String direccion = rs.getString("direccion_profesor");
                String email = rs.getString("email_profesor");
                String telefono = rs.getString("telefono_profesor");

                // Imprimir los resultados.
                System.out.format("%s,%s,%s,%s,%s\n", nombre, apellidos, direccion, email, telefono);

            }

            ps.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllProfesores() {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "SELECT * FROM profesor;";
            Statement stm = db.conectar().createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {

                String dni = rs.getString("dni_profesor"); //Aqui va el campo de la db
                String nombre = rs.getString("nombre_profesor");
                String apellidos = rs.getString("apellidos_profesor");
                String direccion = rs.getString("direccion_profesor");
                String email = rs.getString("email_profesor");
                String telefono = rs.getString("telefono_profesor");
 
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
            query = "UPDATE profesor SET email_profesor = ? WHERE dni_profesor = ?;";
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
            query = "DELETE FROM profesor WHERE dni_profesor = ?;";
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
