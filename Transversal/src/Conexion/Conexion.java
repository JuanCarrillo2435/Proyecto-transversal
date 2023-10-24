package Conexion;

import Data.AlumnoData;
import Entidades.Alumno;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Conexion {
    //establecimos estas constantes que nos van a servir para la conexión
    //url de la base de dato que se va a conectar, que se conecta a una base de datos mariaDB en el servidor localhost
    private static final String URL= "jdbc:mariadb://localhost/";
    //constante de la base de datos a conectar
    private static final String DB= "tptransversal";
    //usuario de conexión
    private static final String USR= "root";
    //contraseña que es una cadena vacía
    private static final String PSW="";
    //definimos una una variable estática de tipo Conecction, la cual se utiliza para establecer una conexión a la base de datos
    private static Connection conection;

    private Conexion() {}
    
    
    public static Connection getConexion(){
        //el if verifica si ya hay una conexion establecida
        if(conection == null){
            try{
            //se utiliza para carsgar el controlodaor de la base de datos
            Class.forName("org.mariadb.jdbc.Driver");
            //establecimos la conexión con la base de datos MariaDB
            conection = DriverManager.getConnection(URL+DB,USR,PSW);
                JOptionPane.showMessageDialog(null, "Conectado");
                

            }catch(ClassNotFoundException ex){
              //  Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al cargar los driver");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DE CONEXIÓN");
            }
        }
        return conection;
    }
    
 
}