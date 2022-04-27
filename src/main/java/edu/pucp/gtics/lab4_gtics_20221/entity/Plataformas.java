package edu.pucp.gtics.lab4_gtics_20221.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "plataformas")
public class Plataformas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = "Plataforma no puede estar vacío")
    private int idplataforma;

    @Size(min=3, max = 45, message = "Debe contener entre 3 y 45 caracteres")
    private String nombre;

    @Size(min=3, max = 198, message = "Debe contener entre 3 y 198 caracteres")
    private String descripcion;

    public int getIdplataforma() {
        return idplataforma;
    }

    public void setIdplataforma(int idplataforma) {
        this.idplataforma = idplataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
