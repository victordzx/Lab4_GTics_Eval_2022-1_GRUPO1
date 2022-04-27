package edu.pucp.gtics.lab4_gtics_20221.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "juegos")
public class Juegos {

    @Id
    private int idjuego;

    @NotBlank
    @Size(min = 3, max = 45, message = "Debe contener entre 3 y 45 caracteres")
    private String nombre;

    @NotBlank
    @Size(min = 3, max = 400, message = "Debe contener entre 3 y 400 caracteres")
    private String descripcion;

    @Digits(integer = 2, fraction = 2)
    @Max(value = 500)
    @Min(value = 10)
    private double precio;

    private String image;

    @ManyToOne
    @JoinColumn(name = "idplataforma")
    @NotBlank
    private Plataformas plataforma;

    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    @NotBlank
    private Distribuidoras distribuidora;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    @NotBlank
    private Generos genero;

    public int getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Plataformas getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataformas plataforma) {
        this.plataforma = plataforma;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Distribuidoras getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidoras distribuidora) {
        this.distribuidora = distribuidora;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }
}
