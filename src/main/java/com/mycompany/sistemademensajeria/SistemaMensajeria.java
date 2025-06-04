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
        
        Usuario usuario = usuarios.get(nombre);
        
        if (usuario!=null && usuario.verificarContraseña(contraseña)){
        usuarioActual = usuario;
        System.out.println("Bienvenido,"+ nombre + "!");
        return true;
    }else{
            System.out.println("Nombre de usuario o contraseña incorrecto");
            return false;
        }
    }
    public void CerrarSesion(){
        usuarioActual = null;
        System.out.println("Sesion cerrada extosamente");
    }
    
    public void RegistrarUsuario(){   
            if (!usuarioActual.esAdmin()){
                System.out.println("Solo el administrador puede registrar nuevos usuarios");
                return;
            }
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        String nombre = scanner.nextLine();
        
        if (usuarios.containsKey(nombre)) {
            System.out.println("El usuario ya existe");
            return;
        }
        System.out.print("Ingrese la contraseña");
        String contraseña = scanner.nextLine();
        
        usuarios.put(nombre, new Usuario(nombre, contraseña, false));
        System.out.println("Usuario "+nombre+" registrado exitosamente");
    
    }

    public void eliminarUsuario(){
        if (!usuarioActual.esAdmin()){
            System.out.println("Solo el adminstrador puede eliminar usuarios");
            return;
            
        }
        
    }
}

