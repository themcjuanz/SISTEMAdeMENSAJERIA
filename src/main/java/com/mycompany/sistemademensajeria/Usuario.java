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
    private final String nombre;
    private String contraseña;
    private final boolean esAdmin;
    private List<Mensaje> bandejaEntrada;
    
    public Usuario(String nombre, String contraseña, boolean esAdmin){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.esAdmin = esAdmin;
        this.bandejaEntrada = new ArrayList<>();
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getContraseña(){
        return contraseña;
    }
    public boolean esAdmin(){
        return esAdmin;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public void recibirMensaje(Mensaje mensaje){
        bandejaEntrada.add(mensaje);
    }
    public boolean verificarContraseña(String contraseña){
        return this.contraseña.equals(contraseña);
    }
    public void mostrarBandejaEntrada(){
        if (bandejaEntrada.isEmpty()){
            System.out.println("No tienes mensajes."); 
        }else{
            System.out.println("\n---BANDEJA DE ENTRADA DE" + nombre.toUpperCase()+"---");
            System.out.println("Total de mensajes:" + bandejaEntrada.size()+"\n");
            for (int i = 0; i < bandejaEntrada.size(); i++){
                System.out.println("Mensaje #" + (i+1)+":");
                System.out.println(bandejaEntrada.get(i));
            }
        }
    }    
}
