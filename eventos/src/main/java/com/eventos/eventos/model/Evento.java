package com.eventos.eventos.model;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="eventos")
public class Evento extends RepresentationModel<Evento> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_evento")
    private Long id_evento;
    @Column(name="evento")
    private String evento;
    @Column(name="fecha")
    private LocalDate fecha;
    @Column(name="tipo")
    private String tipo;
    @Column(name="participantes_maximos")
    private int participantes_maximos;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="tipo_mascota")
    private String tipo_mascota;
    @Column(name="ubicacion")
    private String ubicacion;
    


    public Evento(){
    }

    // GETTERS Y SETTERS
    public Long getId_evento(){
        return id_evento;
    }
    public String getEvento(){
        return evento;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public String getTipo(){
        return tipo;
    }
    public int getParticipantes_maximos(){
        return participantes_maximos;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getTipo_mascota(){
        return tipo_mascota;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    //-------------
    public void setId_evento(Long id_evento){
        this.id_evento=id_evento;
    }
    public void setEvento(String evento){
        this.evento=evento;
    }
    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setParticipantes_maximos(int participantes_maximos){
        this.participantes_maximos=participantes_maximos;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public void setTipo_mascota(String tipo_mascota){
        this.tipo_mascota=tipo_mascota;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion=ubicacion;
    }
}
