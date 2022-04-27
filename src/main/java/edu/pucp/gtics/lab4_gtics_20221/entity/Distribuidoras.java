package edu.pucp.gtics.lab4_gtics_20221.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "distribuidoras")
public class Distribuidoras {

    private int iddistribuidora;

    private String nombre;

    private String descripcion;

    private String web;

    private int fundacion = 1870;

    @ManyToOne
    @JoinColumn(name = "idsede")

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
