package com.tangerine.mvc.model;

public class Cliente {

    private Integer idcliente;
    private String nombre;
    private String descripcion;
    private String logo;

    public Cliente() {
    }

    public Cliente(Integer idcliente, String nombre, String descripcion, String logo) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.logo = logo;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idcliente=" + idcliente +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
