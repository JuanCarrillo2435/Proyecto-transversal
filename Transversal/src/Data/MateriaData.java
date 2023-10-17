package Data;

import Conexion.Conexion;
import Entidades.Materia;
import java.sql.*;
import java.util.List;

public class MateriaData {
    private Connection con;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        
    }
    
    Materia buscarMateria(int id){
        
        return null;
    }
    
    public void modificarMateria(Materia materia){
        
    }
    
    public void eliminarMateria(int id){
        
    }
    
    List<Materia> listarMateria(){
        
        
        return null;
    }
    
    
}
