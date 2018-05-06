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
import model.Familia;

public class FamiliaController {

    public void insert(Familia familia) throws SQLException {
        String query = "";
        Conexion db = new Conexion();

        query = "INSERT INTO familia(nombre_familia) VALUES (?);";
        
        PreparedStatement pstm = db.conectar().prepareStatement(query);
        pstm.setString(1, familia.getNombre());

        if (pstm.executeUpdate() > 0) {
            System.out.println("El registro se insertó exitosamente.");
        } else {
            System.out.println("No se pudo insertar el registro.");
        }

        pstm.close();
        db.conexion.close();
    }

    public void getFamiliaById(int id) {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "SELECT * FROM familia WHERE id_familia = ?;";
            PreparedStatement pstm = db.conectar().prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString("nombre_familia");

                // Imprimir los resultados.
                System.out.format("%s\n", nombre);

            }

            pstm.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllFamilia() {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "SELECT * FROM familia;";
            Statement stm = db.conectar().createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id_familia"); //Aqui va ael campo de la db
                String nombre = rs.getString("nombre_familia");
 
                // Imprimir los resultados.
                System.out.format("%d, %s\n", id, nombre);

            }

            stm.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update_nombre(int id, String str) {
        String query = "";
        Conexion bd = new Conexion();

        try {
            query = "UPDATE familia SET nombre_familia = ? WHERE id_familia = ?;";
            PreparedStatement ps = bd.conectar().prepareStatement(query);
            ps.setString(1, str);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("El registro se actualizó exitosamente.");
            ps.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String query = "";
        Conexion db = new Conexion();

        try {
            query = "DELETE FROM familia WHERE id_familia = ?;";
            PreparedStatement ps = db.conectar().prepareStatement(query);
            ps.setInt(1, id);

            ps.execute();
            System.out.println("El registro se eliminó exitosamente.");
            ps.close();
            db.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
