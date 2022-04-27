package edu.pucp.gtics.lab4_gtics_20221.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "distribuidoras")
public class Distribuidoras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 0, message = "Distribuidora no puede estar vacío")
    private int iddistribuidora;

    @Size(min = 3, max = 50, message = "Debe contener entre 3 y 50 caracteres")
    private String nombre;

    @Size(min = 3, max = 198, message = "Debe contener entre 3 y 198 caracteres")
    private String descripcion;

    @Size(min = 3, max = 198, message = "Debe contener entre 3 y 198 caracteres")
    @URL(protocol = "http")
    private String web;

    @Digits(integer = 4, fraction = 0, message = "Número inválido")
    @Max(value = 2022, message = "Número máximo 2022")
    @Min(value = 1800, message = "Número mínimo 1800")
    private int fundacion ;

    @ManyToOne
    @JoinColumn(name = "idsede")
    @NotNull(message = "Sede no puede estar vacío")
    private Paises pais;

    public int getIddistribuidora() {
        return iddistribuidora;
    }

    public void setIddistribuidora(int iddistribuidora) {
        this.iddistribuidora = iddistribuidora;
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

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }


}
