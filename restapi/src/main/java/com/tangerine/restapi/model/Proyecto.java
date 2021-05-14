package com.tangerine.restapi.model;

import javax.persistence.*;

/**
 * Clase-Entidad conectada a la Base de Datos que mapea la tabla Proyectos
 * Contiene los atributos, getters, setters y toString correspondientes
 */
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproyecto;

    @Column(name = "proyecto")
    private String proyecto;

    @Column(name = "fechafin")
    private String fechafin;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    public Proyecto() {
    }

    public Proyecto(Integer idproyecto, String proyecto, String fechafin, String resumen, String descripcion, String imagen, Cliente cliente) {
        this.idproyecto = idproyecto;
        this.proyecto = proyecto;
        this.fechafin = fechafin;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.cliente = cliente;
    }


    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
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
                "idproyecto=" + idproyecto +
                ", proyecto='" + proyecto + '\'' +
                ", fechafin='" + fechafin + '\'' +
                ", resumen='" + resumen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
