package com.tangerine.mvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author Luis Rojo
 *
 * Clase llamada Persona, con los siguientes atributos: idpersona, nombre, apellidos, resumen,
 * foto, cargo
 */
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpersona;
    private String nombre;
    private String apellidos;
    private String resumen;
    private String foto;
    private Cargo cargo;

    /**
     * Constructor Vacio
     */
    public Persona() {
    }

    /**
     * Constructor con los siguientes parametros
     *
     * @param idpersona
     * @param nombre
     * @param apellidos
     * @param resumen
     * @param foto
     * @param cargo
     */

    public Persona(Integer idpersona, String nombre, String apellidos, String resumen, String foto, Cargo cargo) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.resumen = resumen;
        this.foto = foto;
        this.cargo = cargo;
    }

    /**
     * Getter Y Setters
     *
     * @return
     */

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
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

    /**
     * Metodo toString que devuelve un String con todos los atributos de la clase
     *
     * @return
     */

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
