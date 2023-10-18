package Data;

import Conexion.Conexion;
import Entidades.Alumno;
import Entidades.Inscripcion;
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

    List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> insc = new ArrayList();
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

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

    }

    List<Alumno> obtenerAlumnosXMateria(int idMateria) {

        return null;
    }

}
