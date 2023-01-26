package jpa.ej1.libreria;

import java.util.Scanner;
import jpa.ej1.libreria.entidades.Autor;
import jpa.ej1.libreria.servicios.AutorServicio;
import jpa.ej1.libreria.servicios.EditorialServicio;
import jpa.ej1.libreria.servicios.LibroServicio;

public class JPAEJ1LIBRERIA {

    

    public static void main(String[] args) throws Exception {
        
        Scanner leer = new Scanner(System.in);

        LibroServicio libServ = new LibroServicio();
        AutorServicio autServ = new AutorServicio();
        EditorialServicio editSer = new EditorialServicio();
        
        // PORONGA MUTANTE

        
        
        /// ************ LAS OPCIONES IRIAN ACA, Y LA LOGICA EN CLASE MENU *********** 
        
        
        System.out.println("BIENVENIDOS A LIBRERIA MANCUBSEN");
        System.out.println(" ");
        //MENU//
        
        System.out.println("***AGREGAR LIBROS****");
        libServ.crearLibro();
        
//        System.out.println("CREANDO AUTORES, ESPERE UN INSTANTE");
//        autServ.crearAutor();

//         System.out.println("***BUSQUEDA DE AUTOR POR NOMBRE***");
//          String autor = leer.next();
//          Autor autorx = autServ.buscarAutorPorNombre(autor);
//          System.out.println(autorx.getId() +" / "+ autorx.getNombre());

//        System.out.println("***BUSQUEDA DE LIBRO POR ISBN");
//        System.out.println(" ");
//        System.out.println("Ingrese el ISBN");
//        libServ.buscarLibroPorIsbn();

//        System.out.println("***BUSQUEDA DE LIBRO POR TITULO");
//        System.out.println(" ");
//        System.out.println("Ingrese el titulo");
//        libServ.buscarLibroPorTitulo();

//        System.out.println("BUSQUEDA DE LIBRO POR NOMBRE AUTOR"); 
//        String nombre = leer.next();
//        libServ.buscarLibroPorNautor(nombre);
//        System.out.println(" ");

//        System.out.println("BUSQUEDA DE LIBRO POR NOMBRE EDITORIAL");
//        libServ.buscarLibroPorNedit();
       



    }

}



