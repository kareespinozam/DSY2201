package com.facturacion.facturacion.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.facturacion.model.Factura;
import com.facturacion.facturacion.service.FacturaService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/facturas")
public class FacturacionController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAllFacturas(){
        return facturaService.getAllFacturas();
    }
    
    @GetMapping("/{id}")
    public Optional<Factura> getStudentsById(@PathVariable Long id){
        return facturaService.getFacturaByID(id);
    }
    //CRUD
    @PostMapping
    public Factura createFactura(@RequestBody Factura factura){
        return facturaService.createFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.updateFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id){
        facturaService.deleteFactura(id);
    }
}
