package com.facturacion.facturacion.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.facturacion.model.Factura;;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    
}
