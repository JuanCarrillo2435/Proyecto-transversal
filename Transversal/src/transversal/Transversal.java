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
import java.util.List;

public class Transversal {
    public static void main(String[] args) {

       Connection con= Conexion.getConexion();
      Alumno beto = new Alumno(12 , "Soli", "Marcos", LocalDate.of(2000, Month.APRIL, 28), 42788256, true);
      AlumnoData alumno = new AlumnoData();
      //alumno.guardarAlumno(beto);
     // alumno.eliminarAlumno(12);
      Materia mat = new Materia(1 ,"Programación", 2021, true);
      Materia mat1 = new Materia(1 ,"Lengua", 2108, true);
      
      MateriaData materia = new MateriaData();
    //  materia.modificarMateria(mat1);
    MateriaData guardar = new MateriaData();
     // guardar.guardarMateria(mat);
      List<Materia> b = materia.listarMateria();
       
      if(b != null){
          for (int i = 0; i < b.size(); i++) {
            Materia materia1 = b.get(i);
            System.out.println(materia1);
        }
      }else{
                System.out.println("Lista nula");}
        
      //Materia a = materia.buscarMateria(1);
       // System.out.println(a.toString());
      //InscripcionData g = new InscripcionData();
      //Inscripcion insc = new Inscripcion(8, beto ,mat); 
     // g.guardarInscripcion(insc);
      
     //materia.eliminarMateria(1);
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