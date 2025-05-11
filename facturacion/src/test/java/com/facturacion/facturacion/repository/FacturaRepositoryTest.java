package com.facturacion.facturacion.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.facturacion.facturacion.model.Factura;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturaRepositoryTest {
    @Autowired
    private FacturaRepository facturaRepository;

    @Test
    public void guardarFacturaTest(){
        // Arrange
        Factura factura = new Factura();
        factura.setPrecio(24500);

        //Act
        Factura resultado = facturaRepository.save(factura);

        // Assert
        assertNotNull(resultado.getId_factura());
        assertEquals(24500,resultado.getPrecio());
    }
    @Test
    public void actualizarFacturaTest() {
        // Arrange
        Factura factura = new Factura();
        factura.setPrecio(10000);
        Factura facturaGuardada = facturaRepository.save(factura); // Guardar

        // Act
        facturaGuardada.setPrecio(20000); // Update
        Factura facturaActualizada = facturaRepository.save(facturaGuardada); 

        // Assert
        assertEquals(facturaGuardada.getId_factura(), facturaActualizada.getId_factura());
        assertEquals(20000, facturaActualizada.getPrecio());
    }

}