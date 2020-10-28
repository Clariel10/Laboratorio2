/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class ConexionBD {
    
    private Connection conexion;
    
    public ConexionBD ()
    {
        try {
            
          conexion =   DriverManager.getConnection("jdbc:mysql://localhost/appbanco?serverTimezone=UTC","root","root");
           
            System.out.println("Conectado a la BD");
        } 
        catch (Exception e) {
            
            System.out.println("Error de conexion " + e);
        }
        
        
    }
    
    public Connection RetornarConexion ()
    {
        return conexion;
    
    }     
    
}
