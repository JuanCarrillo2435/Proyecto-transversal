package Data;

import Conexion.Conexion;
import Entidades.Alumno;
import Entidades.Inscripcion;
import java.sql.*;
import java.util.List;

public class InscripcionData {

    private Connection con;
    private MateriaData matData;
    private AlumnoData alumData;

    public InscripcionData() {
        con= Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {

    }

    List<Inscripcion> obtenerInscripciones() {

        return null;
    }

    List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {

        return null;
    }

    List<Inscripcion> obtenerMateriasCursadas(int id) {

        return null;
    }

    List<Inscripcion> obtenerMateriasNOCursadas(int id) {

        return null;
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        
    }
    
    List<Alumno> obtenerAlumnosXMateria (int idMateria){
        
        return null;
    }

}
