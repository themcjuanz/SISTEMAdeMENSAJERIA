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
        System.out.println("Bienvenido,'"+ nombre + "'!");
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
    System.out.print("Ingrese el nombre del usuario a eliminar");
    String nombre = scanner.nextLine();
    
    if (nombre.equals("admin")){
        System.out.println("No se puede eliminar la cuenta del administrador");
        return;     
    }
    
    if (usuarios.remove(nombre) !=null){
        System.out.println("usuario '"+nombre+ "' eliminado exitosamente");
    }else {
        System.out.println("El usuario no existe");
    }
    
}
    
public void BuscarUsuario(){
    System.out.print("Ingrese el nombre del usuario a buscar");
    String nombre = scanner.nextLine();
    
    if (usuarios.containsKey(nombre)) {
       Usuario usuario = usuarios.get(nombre);
       System.out.println("Usuario no encontrado: "+ nombre);
       System.out.println("Tipo: "+ (usuario.esAdmin()? "Administrador" : "Usuario normal"));
       System.out.println("Mensajes en bandeja: "+ usuario.getBandejaEntrada().size());
    }else{
        System.out.println("Usuario no encontrado");
    }
}
    
public void CambiarContraseña(){
    System.out.println("Ingrese su contraseña actual: ");
    String contraseñaActual = scanner.nextLine();
    
    if (!usuarioActual.verificarContraseña(contraseñaActual)){
    System.out.println("Contraseña actual incorrecta");
    return;
}    
    System.out.print("ingrese nueva contraseña: ");
    String nuevaContraseña = scanner.nextLine();
    System.out.print("confirme nueva contraseña: ");
    String confirmacion = scanner.nextLine();
    
    if (nuevaContraseña.equals(confirmacion)){
        usuarioActual.setContraseña(nuevaContraseña);
        System.out.println("Contraseña cambiada exitosamente");
    }else{
        System.out.println("Las contraseñas no coinciden");
    }
}
}


