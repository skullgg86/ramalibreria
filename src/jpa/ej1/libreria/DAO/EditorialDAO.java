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
import jpa.ej1.libreria.entidades.Editorial;

/**
 *
 * @author SkullGG
 */
public class EditorialDAO {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-EJ1-LIBRERIAPU");
    EntityManager em = emf.createEntityManager();
    
    public void subirEditorial(Editorial edit){
        
        
        em.getTransaction().begin();
        em.persist(edit);
        em.getTransaction().commit();
        
    }
    
    public Editorial BuscarEditPorNombre(String nombre){
        
        try {
            
    
        
              Editorial edit = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        
        return edit;
        
            } catch (NoResultException e) {
                
                return null;
        }
        
    }
    
     public Editorial BuscarEditPorId(long id){
        
         try {
             
       
              Editorial edit = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id = :id")
                .setParameter("id", id).getSingleResult();
        
        return edit;
        
          } catch (NoResultException e) {
              
              return null;
         }
        
    }
        
        
    
    
    
}
