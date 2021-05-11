package com.tangerine.mvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Proyecto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String proyecto;
    private String fechafin;
    private String resumen;
    private String descripcion;
    private String imagen;
    private Cliente cliente;

    public Proyecto() {
    }

    public Proyecto(Integer id, String proyecto, String fechafin, String resumen, String descripcion, String imagen, Cliente cliente) {
        this.id = id;
        this.proyecto = proyecto;
        this.fechafin = fechafin;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", proyecto='" + proyecto + '\'' +
                ", fechafin='" + fechafin + '\'' +
                ", resumen='" + resumen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}