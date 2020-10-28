/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexionmysql.ConexionBD;
import com.unab.edu.Entidades.Tipo_Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author DELL
 */
public class ClsTipo_Usuario {
    
    ConexionBD classconectar = new ConexionBD();
    Connection conectar = classconectar.RetornarConexion();
    
     public ArrayList <Tipo_Usuario> MostrarTiposUsuarios(){
        ArrayList <Tipo_Usuario> TipoUsuarios = new ArrayList<>();
        
        
        try {
           
            CallableStatement Statement = conectar.prepareCall("call SP_S_TIPOUSUARIOS");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()){
                
            Tipo_Usuario tipusu = new Tipo_Usuario();            
            tipusu.setId(resultadoDeConsulta.getInt("Id"));
            tipusu.setTipoUser(resultadoDeConsulta.getString("TipoUser"));            
            TipoUsuarios.add(tipusu);
                    
            }
        
            
       } catch (Exception e) {
           
            System.out.println("");
       }
        
        return TipoUsuarios;
    }
    
    
}
