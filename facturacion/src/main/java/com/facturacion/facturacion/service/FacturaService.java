package com.facturacion.facturacion.service;

import com.facturacion.facturacion.model.Factura;
import java.util.List;
import java.util.Optional;
public interface FacturaService {
    List<Factura> getAllFacturas();
    Optional<Factura> getFacturaByID(Long id);

    //CRUD
    Factura createFactura(Factura factura);
    Factura updateFactura(Long id, Factura factura);
    void deleteFactura(Long id);
}
