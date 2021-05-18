package com.tangerine.mvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @Author Albert (Tangerine)
 *
 * Creacion de la clase Mensaje con los siguientes atributos: idmensaje, remitente, fecha, subject, mensaje, respuesta.
 */
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmensaje;
    private String remitente;
    private Timestamp fecha;
    private String subject;
    private String mensaje;
    private String respuesta;

    /**
     * Constructor vacio
     */
    public Mensaje() {
    }

    /**
     * Constructor con los siguientes parametros:
     * @param idmensaje
     * @param remitente
     * @param fecha
     * @param subject
     * @param mensaje
     * @param respuesta
     */
    public Mensaje(Integer idmensaje, String remitente, Timestamp fecha, String subject, String mensaje, String respuesta) {
        this.idmensaje = idmensaje;
        this.remitente = remitente;
        this.fecha = fecha;
        this.subject = subject;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
    }

    /**
     * Getters y Setters
     * @return
     */
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
