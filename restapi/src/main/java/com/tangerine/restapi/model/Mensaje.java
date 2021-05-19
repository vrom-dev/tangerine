package com.tangerine.restapi.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Clase-Entidad conectada a la Base de Datos que mapea la tabla Mensajes
 * Contiene los atributos, getters, setters y toString correspondientes
 */

@Entity
@Table(name="mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmensaje")
    private Integer idmensaje;

    @Column(name="remitente")
    private String remitente;

    @Column(name="fecha")
    private Timestamp fecha;

    @Column(name="subject")
    private String subject;

    @Column(name="mensaje")
    private String mensaje;

    @Column(name="respuesta")
    private String respuesta;

    public Mensaje() {
    }

    public Mensaje(Integer idmensaje, String remitente, Timestamp fecha, String subject, String mensaje, String respuesta) {
        this.idmensaje = idmensaje;
        this.remitente = remitente;
        this.fecha = fecha;
        this.subject = subject;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}




