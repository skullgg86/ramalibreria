package jpa.ej1.libreria.servicios;

import java.util.Collection;
import java.util.Scanner;
import jpa.ej1.libreria.DAO.AutorDAO;
import jpa.ej1.libreria.DAO.EditorialDAO;
import jpa.ej1.libreria.DAO.LibroDAO;
import jpa.ej1.libreria.LibroException;
import jpa.ej1.libreria.entidades.Autor;
import jpa.ej1.libreria.entidades.Editorial;
import jpa.ej1.libreria.entidades.Libro;

public class LibroServicio {
    
  // PROBANDO BRANCH 2

    Scanner leer = new Scanner(System.in);

    EditorialServicio editSer = new EditorialServicio();
    AutorServicio autSer = new AutorServicio();
    
    LibroDAO libroDAO = new LibroDAO();
    AutorDAO autortDAO = new AutorDAO();
    EditorialDAO editDAO = new EditorialDAO();

    // CREAR LIBRO NUEVO
    public void crearLibro() throws LibroException, Exception {

        try {

            Libro librox = new Libro();

            //ATTRIBS LIBRO
            System.out.println("*** LIBRO ****");

            // ISBANANA
            System.out.println(" ");

            System.out.println("Ingrese el ISBANANA");
            Integer isbn = leer.nextInt();
            librox.setIsbn(isbn);

            if (isbn == null) {

                throw new LibroException("Debe ingresar un numero");
            }

            if (libroDAO.buscarLibroPorIsbn(isbn) != null) {

                throw new LibroException("El código ISBN ya existe");
            }

            System.out.println(" ");

            //VALIDAMOS TITULO
            System.out.println("Ingrese el titulo");
            String titulo = leer.next();
            librox.setTitulo(titulo);

            if (titulo == null || titulo.trim().isEmpty()) {

                throw new LibroException("Debe ingresar un nombre");
            }

            if (libroDAO.buscarLibroPorTitulo(titulo) != null) {

                throw new LibroException("Ya existe un libro con ese titulo");
            }

            

            //AÑO DE PUB
            System.out.println(" ");
            System.out.println("Año de publiqueishon:");
            librox.setAnio(leer.nextInt());
            System.out.println(" ");

            //OPCION SEGURA: TRAER LOS SERVICIOS PERO EJECUTAR EL DAO ACA
            System.out.println("***AUTOR***");
            Autor autorx = autSer.crearAutor();
            if (autorx == null) {
                System.out.println("No se ha detectado autor, intente nuevamente");
                crearLibro();
            } else {
                librox.setAutor(autorx);
            }

            System.out.println(" ");

            System.out.println("***EDITORIAL***");

            Editorial edit = editSer.crearEditorial();
            if (edit == null) {
                System.out.println("Editoral no puede estar vacio, vuelva a intentarlo");
                crearLibro();
            } else {

                librox.setEditorial(edit);
            }

            System.out.println(" ");
            System.out.println("ESTA SEGURO ??");
            System.out.println(" ");
            
            editDAO.subirEditorial(edit);
            autortDAO.subirAutor(autorx);
            libroDAO.subirLibro(librox);

        } catch (LibroException e) {

            System.out.println(e.getMessage());

        }

    }

    /// EJ 1 - 9
    public void buscarLibroPorIsbn() {

        //  System.out.println("Ingrese el ISBN");
        int isbn = leer.nextInt();

        Libro librox = libroDAO.buscarLibroPorIsbn(isbn);
        System.out.println(librox.getTitulo() + " - " + librox.getIsbn());
    }

    // EJ 1-10
    public void buscarLibroPorTitulo() {

//        System.out.println("Ingrese el titulo");
        String titulo = leer.next();

        Libro librox = libroDAO.buscarLibroPorTitulo(titulo);

        System.out.println(librox.getIsbn() + " / " + librox.getTitulo() + " / " + librox.getAutor().getNombre());
    }

//        Collection<Libro> libros = libroDAO.buscarLibroPorTitulo(leer.next());
//        for (Libro aux : libros) {
//
//            System.out.println(aux.getIsbn() + " / " + aux.getTitulo());
//
//        }     
    /// EJ 1-11
    public Libro buscarLibroPorNautor(String nombre) {

        Autor autorx = autSer.buscarAutorPorNombre(nombre);

        Libro librox = libroDAO.buscarLibroPorIdAutor(autorx.getId());

        return librox;

//        System.out.println(" ");
//        System.out.println(librox.getIsbn() + " / " + librox.getTitulo() + " / " + librox.getAutor().getNombre() + " / " + librox.getAutor().getId());
    }

    ///EJ 1-12
    public void buscarLibroPorNedit(String nombre) {

        Editorial edit = editSer.buscarEditorialPorNombre(nombre);

        Libro librox = libroDAO.buscarLibroPorIdEdit(edit.getId());

        System.out.println(" ");
        System.out.println(librox.getIsbn() + " / " + librox.getTitulo() + " / " + librox.getEditorial().getNombre() + " / " + librox.getEditorial().getId());

    }

}//FIN CLASE
