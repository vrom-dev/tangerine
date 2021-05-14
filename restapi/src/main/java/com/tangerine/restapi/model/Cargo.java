package com.tangerine.restapi.model;

import javax.persistence.*;
import java.util.List;
/**
 * Clase-Entidad conectada a la Base de Datos que mapea la tabla Cargos
 * Contiene los atributos, getters, setters y toString correspondientes
 */
@Entity
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcargo")
    private int idcargo;

    @Column(name = "cargo")
    private String cargo;

    @OneToMany(mappedBy = "cargo")
    private List<Persona> Personas;

    public Cargo() {
    }

    public Cargo(int idcargo, String cargo) {
        this.idcargo = idcargo;
        this.cargo = cargo;
    }


    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Cargos{" +
                "idcargo=" + idcargo +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
