package com.tangerine.restapi.model;

import javax.persistence.*;
/**
 * Clase-Entidad conectada a la Base de Datos que mapea la tabla Personas
 * Contiene los atributos, getters, setters y toString correspondientes
 */
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "foto")
    private String foto;
    @ManyToOne
    @JoinColumn(name = "cargo")
    private Cargo cargo;


    public Persona() {
    }

    public Persona(int idpersona, String nombre, String apellidos, String resumen, String foto, Cargo cargo) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.resumen = resumen;
        this.foto = foto;
        this.cargo = cargo;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idpersona=" + idpersona +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", resumen='" + resumen + '\'' +
                ", foto='" + foto + '\'' +
                ", cargo=" + cargo +
                '}';
    }
}
