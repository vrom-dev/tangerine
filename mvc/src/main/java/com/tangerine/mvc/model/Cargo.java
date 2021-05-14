package com.tangerine.mvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ALBERTO  (Tangerine)
 *
 * Creacion de una clase llamada Cargos, con los siguentes atributos: idcargo y cargo.
 */

public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcargo;
    private String cargo;

    /**
     * Constructor vacio
     */
    public Cargo() {
    }

    /**
     * Constructor con los siguientes parametros:
     *
     * @param idcargo
     * @param cargo
     */
    public Cargo(Integer idcargo, String cargo) {
        this.idcargo = idcargo;
        this.cargo = cargo;
    }

    /**
     * Getters y Setters
     */
    public Integer getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Integer idcargo) {
        this.idcargo = idcargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Metodo llamado toString que devuelve un String con todos los atributos de la clase Cargos.
     */
    @Override
    public String toString() {
        return "Cargos{" +
                "idcargo=" + idcargo +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
