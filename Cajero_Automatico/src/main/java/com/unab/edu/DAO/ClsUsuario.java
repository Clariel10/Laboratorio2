/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexionmysql.ConexionBD;
import com.unab.edu.Entidades.Usuario;
import com.unab.edu.clase1.cajero_automatico.Administrador;
import com.unab.edu.clase1.cajero_automatico.Usuario_Normal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ClsUsuario {
    
    public Usuario_Normal frmuser = new Usuario_Normal();
  
    
    ConexionBD classconectar = new ConexionBD();
    Connection conectar = classconectar.RetornarConexion();
    
   public boolean LoguinUsuario(String Usuario, String PASS){
        ArrayList <Usuario> ListaUsuarioPass = new ArrayList<>();
        
        try {
           
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGUINUSUARIO(?,?)");
            Statement.setString("pusuario", Usuario);
            Statement.setString("ppass", PASS);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            
                int id = resultadoDeConsulta.getInt("idUsuario");
                String idencontrado = String.valueOf(id);
                frmuser.lblIdUsuario.setText(idencontrado);
               
                
                
            while (resultadoDeConsulta.next()){
                
                Usuario es = new Usuario();
                
                es.setUsuario(resultadoDeConsulta.getString("Usuario"));
                es.setPassword(resultadoDeConsulta.getString("PassWord"));
                ListaUsuarioPass.add(es);
                
            } 
            
            String UsuarioBD = null;
            String ContraBD = null;
                for(var iterador : ListaUsuarioPass){
                    
                UsuarioBD = iterador.getUsuario();
                ContraBD = iterador.getPassword();
                                    
            }
                
                if (UsuarioBD.equals(Usuario) && ContraBD.equals(PASS)){
                    return true;
                }
                conectar.close();
           
       } catch (Exception e) {
           
            System.out.println("Error" + e);
       }
        
         return false;
    
    
} 
   
   public ArrayList <Usuario> MostrarSoloUsuarios(){
        ArrayList <Usuario> Usuarios = new ArrayList<>();
        
        
        try {
           
            CallableStatement Statement = conectar.prepareCall("call SP_S_MOSTRARUSUARIOS");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()){
                
            Usuario usu = new Usuario();            
            usu.setIdUsuario(resultadoDeConsulta.getInt("idUsuario"));
            usu.setPassword(resultadoDeConsulta.getString("PassWord"));
            usu.setTipoUsuario(resultadoDeConsulta.getInt("tipoUsuario"));
            usu.setUsuario(resultadoDeConsulta.getString("Usuario"));       
            Usuarios.add(usu);
                    
            }
        
            
       } catch (Exception e) {
           
            System.out.println("");
       }
        
        return Usuarios;
    }
   
   
}
