package com.facturacion.facturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.facturacion.model.Factura;
import com.facturacion.facturacion.repository.FacturaRepository;

@Service
public class FacturaServicelmpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> getFacturaByID(Long id){
        return facturaRepository.findById(id);
    }

    //CRUD

    @Override
    public Factura createFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    @Override
    public Factura updateFactura(Long id, Factura factura){
        if(facturaRepository.existsById(id)){
            factura.setId_factura(id);
            return facturaRepository.save(factura);
        }else{
            return null;
        }
    }
    @Override
    public void deleteFactura(Long id){
        facturaRepository.deleteById(id);
    }

}
