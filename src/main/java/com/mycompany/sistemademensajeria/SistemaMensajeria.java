/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemademensajeria;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 *
 * @author juanj
 */
public class SistemaMensajeria {
    private Map<String, Usuario> usuarios;
    private Usuario usuarioActual;
    private Scanner scanner;
    
    public SistemaMensajeria(){
        usuarios = new HashMap<>();
        scanner = new Scanner(System.in);
        usuarios.put("admin", new Usuario("admin","admin123", true));    
    }
    
    public boolean iniciarSesion(){
        System.out.print("\nIngrese el usuario");
        String nombre = scanner.nextLine();
        System.out.print("\nIngrese la contraseña");
        String contraseña = scanner.nextLine();
        
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
