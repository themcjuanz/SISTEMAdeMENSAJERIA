/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemademensajeria;


/**
 *
 * @author juanj
 */
class Mensaje {
    private String asunto;
    private String mensaje;
    private String remitente;
    
    public Mensaje(String asunto, String mensaje, String remitente){
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.remitente = remitente;
    }
    
    public String getAsunto(){
        return asunto;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    public String getRemitente(){
        return remitente;
    }
    
    @Override
    public String toString(){
        return String.format("De: %s | Asunto: %s\nMensaje: %s\n%s",
                remitente, asunto, mensaje, "-".repeat(50));
    }
    
}
