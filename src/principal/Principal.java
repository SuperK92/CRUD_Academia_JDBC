/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controller.AlumnoController;
import controller.CursoController;
import controller.FamiliaController;
import controller.ProfesorController;
import controller.MatriculaController;
import java.sql.SQLException;
import model.Familia;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.Profesor;

public class Principal {

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
       Familia familia1 = new Familia("Frio");
       Familia familia2 = new Familia("Informatica");
       FamiliaController familia_controller = new FamiliaController();
       //familia_controller.insert(familia1);
       //familia_controller.insert(familia2);
       //familia_controller.getAllFamilia();
       //familia_controller.getFamiliaById(2);
       //familia_controller.update_nombre(2, "Informatica");
       //familia_controller.getAllFamilia();
       //familia_controller.delete(2);
       //familia_controller.getAllFamilia();
       
       Profesor profe1 = new Profesor("11111111Z", "Alberto", "Medina", "Faro, 22", "alberto@correo.com", "911223344");
       Profesor profe2 = new Profesor("22222222Y", "Maria", "Torres", "Acero, 3", "maria@correo.com", "911223311");
       ProfesorController profe_controller = new ProfesorController();
       //profe_controller.insert(profe1);
       //profe_controller.insert(profe2);
       //profe_controller.getAllProfesores();
       //profe_controller.getProfesorByDni("11111111Z");
       //profe_controller.update_email("11111111Z", "medina@correo.com");
       //profe_controller.getAllProfesores();
       //profe_controller.delete("11111111Y");
       //profe_controller.getAllProfesores();
       
       
       Curso curso1 = new Curso("Sistemas Microinformaticos", 2, "22222222Y");
       Curso curso2 = new Curso("Mantenimiento de Inst de frio", 1, "11111111Z");
       CursoController curso_controller = new CursoController();
       //curso_controller.insert(curso1);
       //curso_controller.insert(curso2);
       //curso_controller.getAllCursos();
       //curso_controller.getAllCursosAvanzado();
       //curso_controller.getCursoById(1);
       //familia_controller.delete(1);
       //curso_controller.getAllCursos();
       //familia_controller.getAllFamilia();
       //curso_controller.update_nombre(1, "Administracion de redes");
       //curso_controller.getAllCursosAvanzado();
       //curso_controller.delete(2);
       //curso_controller.getAllCursos();
       
       
       Alumno alumno1 = new Alumno("11111111A", "Alberto", "Medina", "Faro, 22", "alberto@correo.com", "911223344");
       Alumno alumno2 = new Alumno("11111111B", "Maria", "Torres", "Acero, 3", "maria@correo.com", "911223311");
       AlumnoController alumno_controller = new AlumnoController();
       //alumno_controller.insert(alumno1);
       //alumno_controller.insert(alumno2);
       //alumno_controller.getAllAlumnos();
       //alumno_controller.getAlumnoByDni("11111111A");
       //alumno_controller.update_email("11111111A", "medina@correo.com");
       //alumno_controller.getAllAlumnos();
       //alumno_controller.delete("11111111B");
       //alumno_controller.getAllAlumnos();
       
       
       Matricula matricula1 = new Matricula("11111111A", 1);
       MatriculaController matricula_controller = new MatriculaController();
      //matricula_controller.insert(matricula1);
      //matricula_controller.getAllMatriculas();
      //matricula_controller.cambiar_curso("11111111A", 1, 2);
      //matricula_controller.delete("11111111A", 2);


       
    }
    
}
