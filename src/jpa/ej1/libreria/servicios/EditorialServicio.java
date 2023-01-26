package jpa.ej1.libreria.servicios;

import java.util.Scanner;
import jpa.ej1.libreria.DAO.EditorialDAO;
import jpa.ej1.libreria.LibroException;
import jpa.ej1.libreria.entidades.Editorial;

public class EditorialServicio {
    
    
    //ROBERTO CARLOX

    Scanner leer = new Scanner(System.in);

    EditorialDAO editDAO = new EditorialDAO();

    public Editorial crearEditorial() throws Exception {

        Editorial edit = new Editorial();

        System.out.println("Ingrese el ID del editorial");
        edit.setId(leer.nextInt());

        System.out.println(" ");

        System.out.println("Ingrese el nombre del editorial");
        edit.setNombre(leer.next());

        // System.out.println(" ");
        //  System.out.println("PRESIONE 1 PARA CONFIRMAR NUEVO EDITORIAL");
        //  int opc = leer.nextInt();
        //if (opc == 1) {
        //    editDAO.subirEditorial(edit);
        return edit;

        //   } else {
        //      return null;
        //   }
    }

    public Editorial buscarEditorialPorNombre(String nombre) {

        System.out.println("Ingrese el nombre del editorial");

        Editorial edit = editDAO.BuscarEditPorNombre(nombre);

        return edit;

    }

    public Editorial buscarEditorialPorId(long id) {

        System.out.println("Ingrese el nombre del editorial");

        Editorial edit = editDAO.BuscarEditPorId(id);

        return edit;

    }

}
