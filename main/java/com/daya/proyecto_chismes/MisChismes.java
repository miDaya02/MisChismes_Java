/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.daya.proyecto_chismes;

import java.util.Date;


public class MisChismes {
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private boolean fechaValida;
    private Categoria categoria;
    private Estatus estado;
    
    public MisChismes(String nombre, String descripcion, Date fechaCreacion, boolean fechaValida, Categoria categoria, Estatus estado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaValida = fechaValida;
        this.categoria = categoria;
        this.estado = estado;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isFechaValida() {
        return fechaValida;
    }

    public void setFechaValida(boolean fechaValida) {
        this.fechaValida = fechaValida;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estatus getEstado() {
        return estado;
    }

    public void setEstado(Estatus estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MisChismes{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + ", fechaValida=" + fechaValida + ", categoria=" + categoria + ", estado=" + estado + '}';
    }
}

