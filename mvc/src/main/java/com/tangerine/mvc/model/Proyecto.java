package com.tangerine.mvc.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Alberto (Tangerine)

 * Clase llamada Proyecto, con los siguientes atributos: id, proyecto, fechafin, resumen,
 * descripcion, imagen y cliente.
 */

public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproyecto;
    private String proyecto;
    private String fechafin;
    private String resumen;
    private String descripcion;
    private String imagen;
    private Cliente cliente;

    /**
     * Contructor vacio
     */

    public Proyecto() {
    }

    /**
     * Constructor con los siguientes parametros:
     * @param idproyecto
     * @param proyecto
     * @param fechafin
     * @param resumen
     * @param descripcion
     * @param imagen
     * @param cliente
     */
    public Proyecto(Integer idproyecto, String proyecto, String fechafin, String resumen, String descripcion, String imagen, Cliente cliente) {
        this.idproyecto = idproyecto;
        this.proyecto = proyecto;
        this.fechafin = fechafin;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.cliente = cliente;
    }

    /**
     * Getters y Setters
     */
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

    /**
     * Metodo toString que devuelve un String con todos los atributos de la clase
     *
     */
    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + idproyecto +
                ", proyecto='" + proyecto + '\'' +
                ", fechafin='" + fechafin + '\'' +
                ", resumen='" + resumen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}