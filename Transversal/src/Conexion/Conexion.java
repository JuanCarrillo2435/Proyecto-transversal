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
    private static final String URL= "jdbc:mariadb://localhost/";
    private static final String DB= "tptransversal";
    private static final String USR= "root";
    private static final String PSW="";

    private static Connection conection;

    private Conexion() {}
    
    
    public static Connection getConexion(){
        //el if verifica si ya hay una conexion establecida
        if(conection == null){
            try{
            //cargo el driver
            Class.forName("org.mariadb.jdbc.Driver");
            //establecer conexion
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