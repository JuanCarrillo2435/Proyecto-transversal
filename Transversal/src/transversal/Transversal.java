package transversal;
import Conexion.Conexion;
import Data.AlumnoData;
import Data.InscripcionData;
import Data.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class Transversal {
    public static void main(String[] args) {

       Connection con= Conexion.getConexion();
      Alumno beto = new Alumno(12 , "Soli", "Marcos", LocalDate.of(2000, Month.APRIL, 28), 42788256, true);
      AlumnoData alumno = new AlumnoData();
      //alumno.guardarAlumno(beto);
      Materia mat = new Materia(1 ,"Programación", 2021, true);
     // Materia mat1 = new Materia("Mat", 2, true);
    //  MateriaData guardar = new MateriaData();
      //guardar.guardarMateria(mat);
      
      InscripcionData g = new InscripcionData();
      Inscripcion insc = new Inscripcion(8, beto ,mat); 
      g.guardarInscripcion(insc);
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