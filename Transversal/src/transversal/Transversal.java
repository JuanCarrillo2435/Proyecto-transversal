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

        Connection con = Conexion.getConexion();
        //--------------------------------
        // CREAR OBJETOS DE TIPO ALUMNO
        Alumno beto = new Alumno(12, "Soli", "Marcos", LocalDate.of(2000, Month.APRIL, 28), 42788256, true);
        Alumno martin = new Alumno(10, "Ochoa", "Martin", LocalDate.of(2002, Month.AUGUST, 21), 39082312, true);
        AlumnoData alumno = new AlumnoData();
        //--------------------------------
        //alumno.guardarAlumno(beto);
        // alumno.guardarAlumno(martin);
        // alumno.eliminarAlumno(12);
        //--------------------------------
        //CREAR OBJETOS DE TIPO MATERIA
        MateriaData materia = new MateriaData();
        Materia mat = materia.buscarMateria(3);
        Materia lengua = new Materia(1, "Lengua", 2108, true);

        //--------------------------------
        //  materia.modificarMateria(mat1);
        // MateriaData guardar = new MateriaData();
        // guardar.guardarMateria(mat);
        //--------------------------------
        //CREAMOS UNA LISTA 
        List<Materia> b = materia.listarMateria();

//        if (b != null) {
//            for (int i = 0; i < b.size(); i++) {
//                Materia materia1 = b.get(i);
//                System.out.println(materia1);
//            }
//        } else {
//            System.out.println("Lista nula");
//        }
        InscripcionData i = new InscripcionData();

//        List<Inscripcion> inscr = i.obtenerInscripciones();
//        if (inscr != null) {
//            for (int o = 0; o < inscr.size(); o++) {
//                Inscripcion inscripcion1 = inscr.get(o);
//                System.out.println(inscripcion1);
//            }
//        } else {
//            System.out.println("Lista nula");
//        }
        //---------------------------------
//        List<Inscripcion> obtenerInscIdAl = i.obtenerInscripcionesPorAlumno(12);
//        if (obtenerInscIdAl != null) {
//            for (int o = 0; o < obtenerInscIdAl.size(); o++) {
//                Inscripcion inscripcion1 = obtenerInscIdAl.get(o);
//                System.out.println(inscripcion1);
//            }
//        } else {
//            System.out.println("Lista nula");
//        }
        //--------------------------------
        List<Alumno> obtenerAlumnosPorMateria = i.obtenerAlumnosXMateria(1);
        if (obtenerAlumnosPorMateria != null) {
            for (int o = 0; o < obtenerAlumnosPorMateria.size(); o++) {
                Alumno inscripcion1 = obtenerAlumnosPorMateria.get(o);
                System.out.println(inscripcion1);
            }
        } else {
            System.out.println("Lista nula");
        }

        //Materia a = materia.buscarMateria(1);
        // System.out.println(a.toString());
        //CONSULTAR DUPLICADO
//        InscripcionData g = new InscripcionData();
//        Inscripcion insc = new Inscripcion(10, beto, mat);
//        g.guardarInscripcion(insc);
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
