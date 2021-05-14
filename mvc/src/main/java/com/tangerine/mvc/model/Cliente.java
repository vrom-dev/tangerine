package com.tangerine.mvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Alberto (Tangerine)
 * Creacion de una clase llamada Cliente, con los siguientes atributos: id, nombre, descripcio y logo.
 */
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    private String nombre;
    private String descripcion;
    private String logo;

    /**
     * Constructor vacio
     */
    public Cliente() {
    }

    /**
     * Constructor con los siguientes parametros:
     *
     * @param idcliente
     * @param nombre
     * @param descripcion
     * @param logo
     */
    public Cliente(Integer idcliente, String nombre, String descripcion, String logo) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.logo = logo;
    }

    /**
     * Getters y Setters
     */
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

    /**
     * Metodo toString que devuelve un String con todos los atributos de la clase.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + idcliente +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
