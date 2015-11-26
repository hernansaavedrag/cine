package DLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hernan
 */
public class Conectar {
    
    private Connection conn;
    
    private String registrar(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return "exito";
        } catch (ClassNotFoundException e) {
            return "no registrado";
        }
    }
    
    private String obtenerConexion(){
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cine","root","root");
            return "exito";
        
        } catch (SQLException e) {
            return "no conectado";
        }
        
    }
    
    public Statement crearSentencia(){
        
        try {
            return conn.createStatement();
        } catch (SQLException e) {
            return null;
        }
        
    }

    public Conectar() {
        registrar();
        obtenerConexion();
    }
    
}
