/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemademensajeria;

import java.util.*;

/**
 *
 * @author juanj
 */
public class Usuario {
    private String nombre;
    private String contraseña;
    private boolean esAdmin;
    private List<Mensaje> bandejaEntrada;
    
    public Usuario(String nombre, String contraseña, boolean esAdmin){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.esAdmin = esAdmin;
        this.bandejaEntrada = new ArrayList<>();
            
    }
    
    
}
