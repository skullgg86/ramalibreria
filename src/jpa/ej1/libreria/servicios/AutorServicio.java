package jpa.ej1.libreria.servicios;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import jpa.ej1.libreria.DAO.AutorDAO;
import jpa.ej1.libreria.LibroException;
import jpa.ej1.libreria.entidades.Autor;

public class AutorServicio {
    
    Scanner leer = new Scanner(System.in);
    
    AutorDAO autorDAO = new AutorDAO();

    //CREAR AUTOR
    public Autor crearAutor() throws LibroException, InputMismatchException {
        
        try {
            
            Autor autorx = new Autor();
            
            System.out.println("Ingrese el ID del autor");
            Integer id = leer.nextInt();
            
            if (id == null) {
                throw new LibroException("Debe ingresar un numero");
            }
            
            if (autorDAO.buscarAutorPorId(id) != null) {
                
                throw new LibroException("Ese ID ya existe");
            }
            
            System.out.println(" ");
            
            System.out.println("Ingrese el nombre");
            String nombre = leer.next();
            
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new LibroException("Debe ingresar un nombre");
            }
            
            if (autorDAO.buscarAutorPorNombre(nombre) != null) {
                
                throw new LibroException("El nombre ya existe");
            }


                
                autorx.setId(id);
                autorx.setNombre(nombre);
               // autorDAO.crearAutor(autorx);
                return autorx;
                
           // } else {
                
         //        return null;
         //   }
            
        } catch (LibroException e) {
            
            System.out.println(e.getMessage());
            return null;
        }
        
    
        
    }
    
    public Autor buscarAutorPorNombre(String nombre) {

        //      System.out.println("Ingrese el nombre del autor");
        Autor autorx = autorDAO.buscarAutorPorNombre(nombre);
        
        return autorx;
        
    }
    
    public Autor buscarAutorPorId() {
        
        long id = leer.nextLong();
        
        return autorDAO.buscarAutorPorId(id);
        
    }
    
}
