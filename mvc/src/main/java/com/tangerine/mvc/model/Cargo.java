package com.tangerine.mvc.model;
/**
 * @author ALBERTO  (Tangerine)
 */
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Creacion de una clase llamada Cargos, con los siguentes atributos: idCargo y cargo.
 */

public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;
    private String cargo;

    /**
     * Constructor vacio
     */
    public Cargo() {
    }

    /**
     * Constructor con los siguientes parametros:
     * @param idCargo
     * @param cargo
     */
    public Cargo(Integer idCargo, String cargo) {
        this.idCargo = idCargo;
        this.cargo = cargo;
    }

    /**
     * Getters y Setters
     */
    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
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
                "idCargo=" + idCargo +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
