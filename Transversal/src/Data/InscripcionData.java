package Data;

import Conexion.Conexion;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con;
    private MateriaData matData;
    private AlumnoData alumData;
    private Inscripcion insc;

    public InscripcionData() {
        con = Conexion.getConexion();

    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                insc.setIdInscripto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");
        }

    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getInt("nota"));

                // Obtener información relacionada de Alumno y Materia y asignarla a Inscripcion
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                inscripcion.setAlumno(alumno); // Supongamos que Inscripcion tiene un método setAlumno

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                inscripcion.setMateria(materia); // Supongamos que Inscripcion tiene un método setMateria

                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion: " + ex.getMessage());
        }

        return inscripciones;
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

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

    }

    List<Alumno> obtenerAlumnosXMateria(int idMateria) {

        return null;
    }

}
