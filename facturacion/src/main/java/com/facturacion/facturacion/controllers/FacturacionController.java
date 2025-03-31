package com.facturacion.facturacion.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.facturacion.facturacion.models.Factura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturacionController {
    private List<Factura> facturas = new ArrayList<>();

    public FacturacionController(){
        facturas.add(new Factura(1, "Consulta General",LocalDate.parse("2025-03-20"),"Veterinaria Gatofeliz","20.435.399-9","Karel Espinoza","Gato","Mantequilla",14990 ));
        facturas.add(new Factura(2, "Vacunación Antirrábica", LocalDate.parse("2025-03-25"), "Veterinaria Gatofeliz","15.987.654-3", "Laura Martínez", "Perro", "Draco", 19990));
        facturas.add(new Factura(3, "Desparasitación", LocalDate.parse("2025-04-02"), "Veterinaria Gatofeliz","18.456.789-5", "Carlos Núñez", "Gato", "Mishi", 12990));
        facturas.add(new Factura(4, "Cirugía de esterilización", LocalDate.parse("2025-04-10"), "Veterinaria Gatofeliz","22.345.678-1", "Ana Gómez", "Conejo", "Bolita", 49990));
        facturas.add(new Factura(5, "Consulta Dermatológica", LocalDate.parse("2025-04-15"), "Veterinaria Gatofeliz","25.678.901-2", "Javier Pérez", "Perro", "Stella", 24990));
    }

    @GetMapping("/facturas")
    public List<Factura> getFacturas(){
        return facturas;
    }

    @GetMapping("/facturas/{id_factura}")
    public Factura getFacturaById(@PathVariable int id_factura){
        for (Factura f : facturas){
            if (f.getId_factura()== id_factura){
                return f;
            }
        }
        return null;
    }
}
