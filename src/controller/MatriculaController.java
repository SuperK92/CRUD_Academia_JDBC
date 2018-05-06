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
import model.Matricula;

public class MatriculaController {
    public void insert(Matricula matricula) throws SQLException {
        String query = "";
        Conexion db = new Conexion();

        query = "INSERT INTO matricula VALUES (?,?);";
        
        PreparedStatement ps = db.conectar().prepareStatement(query);
        ps.setString(1, matricula.getAlumno());
        ps.setInt(2, matricula.getCurso());

        if (ps.executeUpdate() > 0) {
            System.out.println("El registro se insertó exitosamente.");
        } else {
            System.out.println("No se pudo insertar el registro.");
        }

        ps.close();
        db.conexion.close();
    }


    public void getAllMatriculas() {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "SELECT * FROM matricula;";
            Statement stm = db.conectar().createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                
                String alumno = rs.getString("id_alumno");
                int curso = rs.getInt("id_curso");
                

                // Imprimir los resultados.
                System.out.format("%s,%d\n", alumno, curso);

            }

            stm.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //cambiar a un alumno de un curso a otro, para ello debe conincidir el alumno y el curso actual para luego
    //cambiarlo por el nuevo curso

    public void cambiar_curso(String alumno, int cursoActual, int cursoNuevo) {
        String query = "";
        Conexion bd = new Conexion();

        try {
            query = "UPDATE matricula SET id_curso = ? WHERE id_alumno = ? AND id_curso = ?;";
            PreparedStatement ps = bd.conectar().prepareStatement(query);
            ps.setInt(1, cursoNuevo);
            ps.setString(2, alumno);
            ps.setInt(3, cursoActual);

            ps.executeUpdate();
            System.out.println("El registro se actualizó exitosamente.");
            ps.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Para eliminar una matricula de un alumno en una asignatura
    public void delete(String alumno, int curso) {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "DELETE FROM matricula WHERE id_alumno = ? AND id_curso = ?;";
            PreparedStatement ps = db.conectar().prepareStatement(query);
            ps.setString(1, alumno);
            ps.setInt(2, curso);

            ps.execute();
            System.out.println("El registro se eliminó exitosamente.");
            ps.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
