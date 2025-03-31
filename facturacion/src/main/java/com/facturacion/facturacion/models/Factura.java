package com.facturacion.facturacion.models;
import java.time.LocalDate;

public class Factura {
    private int id_factura;
    private String servicio;
    private LocalDate fecha;
    private String emisor;
    private String rut_cliente;
    private String nombre_cliente;
    private String tipo_mascota;
    private String nombre_mascota;
    private int precio;
    


    public Factura(int id_factura, String servicio, LocalDate fecha, String emisor,String rut_cliente,String nombre_cliente,String tipo_mascota,String nombre_mascota,int precio){
        this.id_factura = id_factura;
        this.servicio = servicio;
        this.fecha = fecha;
        this.emisor = emisor;
        this.rut_cliente = rut_cliente;
        this.nombre_cliente = nombre_cliente;
        this.tipo_mascota = tipo_mascota;
        this.nombre_mascota = nombre_mascota;
        this.precio = precio;
    }

    // GETTERS Y SETTERS
    public int getId_factura(){
        return id_factura;
    }

    public String getservicio(){
        return servicio;
    }
    public LocalDate getfecha(){
        return fecha;
    }
    public String getemisor(){
        return emisor;
    }
    public String getrut_cliente(){
        return rut_cliente;
    }
    public String getnombre_cliente(){
        return nombre_cliente;
    }
    public String gettipo_mascota(){
        return tipo_mascota;
    }
    public String getnombre_mascota(){
        return nombre_mascota;
    }
    public int getprecio(){
        return precio;
    }




}
