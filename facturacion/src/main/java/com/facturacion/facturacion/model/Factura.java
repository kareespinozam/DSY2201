package com.facturacion.facturacion.model;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="facturas")
public class Factura  extends RepresentationModel<Factura>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_FACTURA")
    private Long id_factura;
    @Column(name="SERVICIO")
    private String servicio;
    @Column(name="fecha")
    private LocalDate fecha;
    @Column(name="emisor")
    private String emisor;
    @Column(name="rut_cliente")
    private String rut_cliente;
    @Column(name="nombre_cliente")
    private String nombre_cliente;
    @Column(name="tipo_mascota")
    private String tipo_mascota;
    @Column(name="nombre_mascota")
    private String nombre_mascota;
    @Column(name="precio")
    private int precio;

    public Factura() {
    
    }

    // GETTERS
    public Long getId_factura(){
        return id_factura;
    }
    public String getServicio(){
        return servicio;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public String getEmisor(){
        return emisor;
    }
    public String getRut_cliente(){
        return rut_cliente;
    }
    public String getNombre_cliente(){
        return nombre_cliente;
    }
    public String getTipo_mascota(){
        return tipo_mascota;
    }
    public String getNombre_mascota(){
        return nombre_mascota;
    }
    public int getPrecio(){
        return precio;
    }
    //SETTERS
    public void setId_factura(Long id_factura){
        this.id_factura=id_factura;
    }
    public void setServicio(String servicio){
        this.servicio=servicio;
    }
    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }
    public void setEmisor(String emisor){
        this.emisor=emisor;
    }
    public void setRut_cliente(String rut_cliente){
        this.rut_cliente=rut_cliente;
    }
    public void setNombre_cliente(String nombre_cliente){
        this.nombre_cliente=nombre_cliente;
    }
    public void setTipo_mascota(String tipo_mascota){
        this.tipo_mascota=tipo_mascota;
    }
    public void setNombre_mascota(String nombre_mascota){
        this.nombre_mascota=nombre_mascota;
    }
    public void setPrecio(int precio){
        this.precio=precio;
    }
}
