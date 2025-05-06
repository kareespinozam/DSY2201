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
    private FacturaRepository eventoRepository;

    @Test
    public void guardarFacturaTest(){
        // Arrange
        Factura evento = new Factura();
        evento.setPrecio(24500);

        //Act
        Factura resultado = eventoRepository.save(evento);

        // Assert
        assertNotNull(resultado.getId_factura());
        assertEquals(24500,resultado.getPrecio());
    }
    // Otras pruebas
}
