package com.facturacion.facturacion.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<EntityModel<Factura>> getAllFacturas(){
        List<Factura> facturas = facturaService.getAllFacturas();

        List<EntityModel<Factura>> facturaResources = facturas.stream()
                .map(factura -> EntityModel.of(factura,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturasById(factura.getId_factura())).withSelfRel()
                    ))
                .collect(Collectors.toList());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas());
        CollectionModel<EntityModel<Factura>> resources = CollectionModel.of(facturaResources,linkTo.withRel("facturas"));

        return resources;
    }
    
    @GetMapping("/{id}")
    public EntityModel<Factura> getFacturasById(@PathVariable Long id){
        Optional<Factura> factura = facturaService.getFacturaByID(id);
        if (factura.isPresent()) {
            return EntityModel.of(factura.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturasById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withRel("all-facturas"));
        }else{
            throw new FacturaNotFoundException("Factura no encontrado con id: " + id);
        }
    }
    //CRUD
    @PostMapping
    public EntityModel<Factura> createFactura(@RequestBody Factura factura){
        Factura createdFactura = facturaService.createFactura(factura);
        return EntityModel.of(createdFactura,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturasById(createdFactura.getId_factura())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withRel("all-facturas"));
    }

    @PutMapping("/{id}")
    public EntityModel<Factura> updatefactura(@PathVariable Long id,@RequestBody Factura factura){
        Factura updatedFactura = facturaService.updateFactura(id, factura);
        return EntityModel.of(updatedFactura,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturasById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withRel("all-facturas"));
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id){
        facturaService.deleteFactura(id);
    }
}
