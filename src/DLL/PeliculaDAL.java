/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import BLL.Pelicula;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hernan
 */
public class PeliculaDAL {
    
    Conectar conectar;

    public PeliculaDAL() {
        conectar = new Conectar();
    }
    
    
    public int guardar(Pelicula pel){
        
        Statement stmt = conectar.crearSentencia();
        try {
            
            int resultado = stmt.executeUpdate("insert into pelicula values ('"+ pel.getCodigo()+"','"+pel.getNombre()+"','"+pel.getCategoria()+"',"+pel.getDiasPrestamo()+",'"+pel.getFormato()+"',"+pel.getFechaIngreso()+")");
             
            return resultado;
            
        } catch (SQLException e) {
            
            if (e.getErrorCode() == 1062) {
                return -1;
            }
            else{
                return -2;
            }
        }
        
    }
   
    
}
