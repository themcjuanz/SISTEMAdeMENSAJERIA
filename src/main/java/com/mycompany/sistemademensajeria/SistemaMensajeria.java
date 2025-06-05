/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    private final Map<String, Usuario> usuarios;
    private Usuario usuarioActual;
    private final Scanner scanner;
    
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
    public void cerrarSesion(){
        usuarioActual = null;
        System.out.println("Sesion cerrada extosamente");
    }
    
    public void registrarUsuario(){   
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
    
        public void buscarUsuario(){
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
    
        public void cambiarContraseña(){
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
    public void enviarMensaje(){
        if (usuarioActual.esAdmin()){
            System.out.println("El administrador no puede enviar mensajes");
            return;
        }
        System.out.print("Ingrese nombre del destinatario: ");
        String destinatario = scanner.nextLine();
        Usuario usuarioDestinatario = usuarios.get(destinatario);
        
        if (usuarioDestinatario == null){
            System.out.println("El usuario destinatario no existe");
            return;
        }
            
        if (usuarioDestinatario.esAdmin()){
            System.out.println("No se puede enviar mensajes al administrador");
            return;
        }
        System.out.print("Ingrese asunto: ");
        String asunto = scanner.nextLine();
        System.out.print("Ingrese el mensaje: ");
        String contenido = scanner.nextLine();
        
        Mensaje mensaje = new Mensaje(asunto, contenido, usuarioActual.getNombre());
        usuarioDestinatario.recibirMensaje(mensaje);
        
        System.out.println("Mensaje enviado exitosamente a " + destinatario);
    }
    
    public void mostrarTodosLosUsuarios(){
        if (!usuarioActual.esAdmin()){
            System.out.println("Solo el administrador puede ver todos los usuarios");
            return;
        }
        System.out.println("\n---LISTA DE USUARIOS---");
        System.out.println("Total de usuarios" + usuarios.size());
        System.out.println("-".repeat(50));
        
        for (Usuario usuario: usuarios.values()){
            System.out.println("*"+usuario.getNombre()+(usuario.esAdmin()?"(Administrador)":"(Usuario)")+"Mensajes:" + usuario.getBandejaEntrada().size());
        }
    }
    public void mostrarMenuAdministrador(){
        System.out.println("\n---MENU ADMINISTRADOR---");
        System.out.println("1. registrar nuevo usuario");
        System.out.println("2. Eliminar usuario");
        System.out.println("3. Buscar usuario");
        System.out.println("4. Mostrar todos los usuarios");
        System.out.println("5. Cambiar contraseña");
        System.out.println("6. Cerrar sesion");
        System.out.println("7. Salir del sistema");
    }
    
    public void mostrarMenuUsuario(){
        System.out.println("\n---MENU USUARIO---");
        System.out.println("1. Ver bandeja de entrada");
        System.out.println("2. Enviar mensaje");
        System.out.println("3. Cambiar contraseña");
        System.out.println("4. Cerrar sesion");
        System.out.println("5. Salir del sistema");
    }

    public void ejecutar(){
        try (scanner) {
            boolean sistemaActivo = true;
            
            while (sistemaActivo){
                if (usuarioActual == null){
                    System.out.println("\n=== SISTEMA DE MENSAJERÍA ===");
                    System.out.println("1. Iniciar sesión");
                    System.out.println("2. Salir");
                    System.out.println("Seleccione una opción");
                    
                    try {
                        int opcion = Integer.parseInt(scanner.nextLine());
                        switch (opcion){
                            case 1 -> iniciarSesion();
                            case 2 -> {
                                sistemaActivo = false;
                                System.out.println("¡Hasta luego!");
                            }
                            default -> System.out.println("Opción no válida");
                        }
                        
                    } catch (NumberFormatException e){
                        System.out.println("Por favor, ingrese un número válido");
                    }
                }else {
                    if (usuarioActual.esAdmin()){
                        mostrarMenuAdministrador();
                    } else {
                        mostrarMenuUsuario();
                    }
                    System.out.print("Seleccione una opción");
                    
                    try {
                        int opcion = Integer.parseInt(scanner.nextLine());
                        if (usuarioActual.esAdmin()){ 
                            switch (opcion) {
                                case 1 -> registrarUsuario();
                                case 2 -> eliminarUsuario();
                                case 3 -> buscarUsuario();
                                case 4 -> mostrarTodosLosUsuarios();
                                case 5 -> cambiarContraseña();
                                case 6 -> cerrarSesion();
                                case 7 -> {
                                    sistemaActivo = false; System.out.println("¡Hasta luego!");
                                }
                                default -> System.out.println("Opción no válida");
                            }
                        }else {
                            switch (opcion){
                                case 1 -> usuarioActual.mostrarBandejaEntrada();
                                case 2 -> enviarMensaje();
                                case 3 -> cambiarContraseña();
                                case 4 -> cerrarSesion();
                                case 5 -> {
                                    sistemaActivo = false; System.out.println("!Hasta luego!");
                                }
                                default -> System.out.println("Opción no válida");
                            }
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Por favor, ingrese un número válido");
                    }
                }
            }  
        }
        }
    
    
    public static void main(String[] args) {
        SistemaMensajeria sistema = new SistemaMensajeria();
        sistema.ejecutar();
    }
} 



