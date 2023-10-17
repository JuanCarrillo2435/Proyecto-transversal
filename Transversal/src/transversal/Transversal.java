package transversal;
import Conexion.Conexion;
import Data.AlumnoData;
import Entidades.Alumno;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class Transversal {
    public static void main(String[] args) {

       Connection con= Conexion.getConexion();
        Alumno beto = new Alumno("Correa", "Alberto", LocalDate.of(2000, Month.APRIL, 28), 42744249, true);
      AlumnoData alumno = new AlumnoData();
      alumno.guardarAlumno(beto);
       /* Alumno encontrado=  alumno.buscarAlumno(8);
     //agregar if =!null
        System.out.println("dni: "+ encontrado.getDni());
        System.out.println("Nombre completo: "+encontrado.getApellido()+" "+ encontrado.getNombre());*/
        ///////////////////////////
       /* Alumno encontradoDni=  alumno.buscarAlumnoPorDni(42744249);
                System.out.println("dni: "+ encontradoDni.getDni());
        System.out.println("Nombre completo: "+encontradoDni.getApellido()+" "+ encontradoDni.getNombre());*/
       //alumno.modificarAlumno(beto);
      // alumno.eliminarAlumno(8);
      
      
    }
    
}