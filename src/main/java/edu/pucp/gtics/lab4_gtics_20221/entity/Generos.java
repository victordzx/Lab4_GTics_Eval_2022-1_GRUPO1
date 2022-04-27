package edu.pucp.gtics.lab4_gtics_20221.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "generos")

public class Generos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = "Género no puede estar vacío")
    private
    int idgenero;
    private String nombre;
    private String descripcion;

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
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
