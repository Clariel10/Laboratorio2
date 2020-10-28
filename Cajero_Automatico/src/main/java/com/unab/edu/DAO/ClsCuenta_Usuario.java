/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Conexionmysql.ConexionBD;
import com.unab.edu.Entidades.Cuenta_Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ClsCuenta_Usuario {
    
     ConexionBD classconectar = new ConexionBD();
    Connection conectar = classconectar.RetornarConexion();
    
     public ArrayList <Cuenta_Usuario> MostrarCuentas(){
        ArrayList <Cuenta_Usuario> Cuentas = new ArrayList<>();
        
        
        try {
           
            CallableStatement Statement = conectar.prepareCall("call SP_S_CUENTAUSUARIO");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()){
                
            Cuenta_Usuario cuen = new Cuenta_Usuario();            
            cuen.setIdCuentaUsuario(resultadoDeConsulta.getInt("idcuentasusuario"));
            cuen.setIdUsuario(resultadoDeConsulta.getInt("idUsuario"));
            cuen.setSaldo(resultadoDeConsulta.getDouble("saldo"));
            cuen.setTransaccion(resultadoDeConsulta.getInt("transaccion"));      
            cuen.setFecha(resultadoDeConsulta.getDate("fecha"));  
            Cuentas.add(cuen);
                    
            }
        
            
       } catch (Exception e) {
           
            System.out.println("");
       }
        
        return Cuentas;
    }
    
     public void AgregarTransaccion(Cuenta_Usuario per)
   {
       try {
           
           CallableStatement Statement = conectar.prepareCall("call SP_I_CUENTAUSUARIO(?,?,?,?)");
           Statement.setDouble("psaldo", per.getSaldo());
           Statement.setInt("pidusuario", per.getIdUsuario());
           Statement.setInt("ptransaccion", per.getTransaccion());
           Statement.setDate("pfecha", (Date) per.getFecha());
           Statement.execute();
           JOptionPane.showMessageDialog(null, "HECHO");
            conectar .close();
           
       } catch (Exception e) {
           
           JOptionPane.showMessageDialog(null, e);
       }
        
   
   }
     
}
