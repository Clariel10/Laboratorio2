/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author DELL
 */
@Data
public class Cuenta_Usuario {
    
    private int idCuentaUsuario;
    private double saldo;
    private int idUsuario;
    private int transaccion;
    private Date fecha;
    
}
