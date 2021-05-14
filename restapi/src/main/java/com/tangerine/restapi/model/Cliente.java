package com.tangerine.restapi.model;

import javax.persistence.*;
import java.util.List;

/**
 * Clase-Entidad conectada a la Base de Datos que mapea la tabla Clientes
 * Contiene los atributos, getters, setters y toString correspondientes
 */
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Integer idcliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "logo")
    private String logo;

    @OneToMany(mappedBy = "cliente")
    private List<Proyecto> proyectos;

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
