
package jpa.ej1.libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {
    
    @Id
    Integer id;
    String nombre;
    Boolean alta;

    public Autor() {
    }
    
    
    public Autor(Integer id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
    
    
    
}
