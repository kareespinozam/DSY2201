package com.eventos.eventos.models;
import java.time.LocalDate;

public class Evento {
    private int id_evento;
    private String evento;
    private LocalDate fecha;
    private String tipo;
    private int participantes_maximos;
    private String descripcion;
    private String tipo_mascota;
    private String ubicacion;
    


    public Evento(
        int id_evento,String evento,LocalDate fecha,String tipo,int participantes_maximos,String descripcion,String tipo_mascota,String ubicacion){
        this.id_evento = id_evento;
        this.evento = evento;
        this.fecha = fecha;
        this.tipo = tipo;
        this.participantes_maximos = participantes_maximos;
        this.descripcion = descripcion;
        this.tipo_mascota = tipo_mascota;
        this.ubicacion = ubicacion;
    }

    // GETTERS Y SETTERS
    public int getId_evento(){
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

}
