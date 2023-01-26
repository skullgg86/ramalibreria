/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ej1.libreria.DAO;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import jpa.ej1.libreria.entidades.Libro;

/**
 *
 * @author SkullGG
 */
public class LibroDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EJ1-LIBRERIAPU");
    EntityManager em = emf.createEntityManager();

    public void subirLibro(Libro librox) {

        em.getTransaction().begin();
        em.persist(librox);
        em.getTransaction().commit();

    }

    public Libro buscarLibroPorIsbn(int isbn) {

        try {

            Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn")
                    .setParameter("isbn", isbn).getSingleResult();

            return libro;
            
              } catch (NoResultException e) {
                  
                  return null;
        }

        }

      

    public Libro buscarLibroPorTitulo(String titulo) {

        try {
            
     
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo =:titulo ")
                .setParameter("titulo", titulo).getSingleResult();
        

        return libro;
    
        
           } catch (NoResultException e) {
    
    return null;
    
        }
    }
    
//    public Collection<Libro> buscarLibroPorTitulo(String titulo) {
//        
//        Collection<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo =:titulo ")
//                .setParameter("titulo",titulo).getResultList();
//        
//
//        return libros;
//    }
    public Libro buscarLibroPorIdAutor(int id_autor) {

        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.autor.id = :id_autor")
                .setParameter("id_autor", id_autor).getSingleResult();

        return libro;

    }

    public Libro buscarLibroPorIdEdit(int id_editorial) {

        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.editorial.id = :id_editorial")
                .setParameter("id_editorial", id_editorial).getSingleResult();

        return libro;

    }

}
