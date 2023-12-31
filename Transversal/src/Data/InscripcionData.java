package Data;

import Conexion.Conexion;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                inscripcion.setAlumno(alumno);

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                inscripcion.setMateria(materia);

                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion: " + ex.getMessage());
        }

        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
         List<Inscripcion> inscripciones = new ArrayList<>();
        try {
            String sql = "SELECT idInscripto, idAlumno, materia.idMateria, materia.nombre, nota FROM inscripcion JOIN materia ON (inscripcion.idMateria = materia.idMateria) WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripto(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getInt("nota"));

                // Obtener información relacionada de Alumno y Materia y asignarla a Inscripcion
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                inscripcion.setAlumno(alumno); 

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                inscripcion.setMateria(materia);

                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion: " + ex.getMessage());
        }

        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<>();
        
        try {
        String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion,"
                   + " materia WHERE inscripcion.idMateria = materia.idMateria\n"
                   + "AND inscripcion.idAlumno = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Materia materia;
        while (rs.next()) {
            materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("anio"));
            materias.add(materia);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones: " + ex.getMessage());
    }
    
        return materias;
    }

   
    public List<Materia> obtenerMateriasNOCursadas(int id) {
        
        ArrayList<Materia> materias = new ArrayList<>();
         
        try {
             String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
            
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 
            Materia materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("anio"));
            materias.add(materia);
                
             }
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return materias;
    }

  public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
    try {
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ps.setInt(2, idMateria);
        
        int filasBorradas = ps.executeUpdate();
        
        if (filasBorradas > 0) {
            JOptionPane.showMessageDialog(null, "Inscripción eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una inscripción correspondiente al alumno y materia especificados.");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar la inscripción: " + ex.getMessage());
    }
}


  public void actualizarNota(int idAlumno, int idMateria, double nota) {
    try {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, nota);
        ps.setInt(2, idAlumno);
        ps.setInt(3, idMateria);
        
        int filasActualizadas = ps.executeUpdate();
        
        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "Nota actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una inscripción correspondiente al alumno y materia especificados.");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + ex.getMessage());
    }
}


  public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
    List<Alumno> alumnos = new ArrayList<>();
    try {
        String sql = "SELECT a.* FROM alumno a " +
                     "INNER JOIN inscripcion i ON a.idAlumno = i.idAlumno " +
                     "WHERE i.idMateria = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idMateria); // Configurar el parámetro idMateria en la consulta SQL
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellido(rs.getString("apellido"));
            alumno.setFechaDeNacimiento(rs.getDate("fechaDeNacimiento").toLocalDate());
            alumno.setEstado(true);
            // Otros atributos de Alumno

            alumnos.add(alumno);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno: " + ex.getMessage());
    }

    return alumnos;
}


}

