/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ej1.libreria.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import jpa.ej1.libreria.entidades.Autor;

/**
 *
 * @author SkullGG
 */
public class AutorDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EJ1-LIBRERIAPU");
    EntityManager em = emf.createEntityManager();

    public void subirAutor(Autor autorx) {

        em.getTransaction().begin();
        em.persist(autorx);
        em.getTransaction().commit();

    }

    public Autor buscarAutorPorNombre(String nombre) {

        try {
            
      
        Autor autorx = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                .setParameter("nombre", nombre).getSingleResult();

        return autorx;

          } catch (NoResultException e) {
              return null;
        }
    }

    public Autor buscarAutorPorId(long id) {

        try {
            
     
        Autor autorx = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id = :id")
                .setParameter("id", id).getSingleResult();

        return autorx;

           } catch (NoResultException e) {
               
               return null;
        }
    }

}

// SI DEVUELVE LISTA VA ASI:        
//        Collection<Autor> listautor;
//        
//        listautor = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
//                .setParameter("nombre", nombre).getResultList();
//        
//        return listautor;
