package com.tangerine.mvc.model;

public class Proyecto {

    private Integer idproyecto;
    private String proyecto;
    private String fechafin;
    private String resumen;
    private String descripcion;
    private String imagen;
    private Cliente idcliente;

    public Proyecto() {
    }

    public Proyecto(Integer idproyecto, String proyecto, String fechafin, String resumen, String descripcion, String imagen, Cliente idcliente) {
        this.idproyecto = idproyecto;
        this.proyecto = proyecto;
        this.fechafin = fechafin;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.idcliente = idcliente;
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

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
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
                ", idcliente=" + idcliente +
                '}';
    }
}