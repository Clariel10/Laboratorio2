/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.*;
/**
 *
 * @author DELL
 */
@Data
public class Usuario {
    
    private int idUsuario;
    private String usuario;
    private String password;
    private int tipoUsuario;
    
    
}
