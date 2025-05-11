package com.facturacion.facturacion.controller;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.facturacion.facturacion.controllers.FacturacionController;
import com.facturacion.facturacion.model.Factura;
import com.facturacion.facturacion.service.FacturaServicelmpl;

@WebMvcTest(FacturacionController.class)
public class FacturaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private FacturaServicelmpl facturaServicioMock;

    @Test
    public void obetenerTodosTest() throws Exception{
        // Arrange
        Factura factura1 = new Factura();
        factura1.setPrecio(19990);
        factura1.setId_factura(1L);
        Factura factura2 = new Factura();
        factura2.setPrecio(69420);
        factura2.setId_factura(2L);
        List<Factura> facturacion = Arrays.asList(factura1,factura2);
        when(facturaServicioMock.getAllFacturas()).thenReturn(facturacion);
        
        //Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/facturas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.aMapWithSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.facturaList[0].precio",Matchers.is(19990)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.facturaList[1].precio",Matchers.is(69420))
                );

    }
    @Test
    public void obtenerPorID() throws Exception {
        // Arrange
        Long idBuscado = 1L;
        Factura factura = new Factura();
        factura.setId_factura(idBuscado);
        factura.setPrecio(19990);
        
        // Mockeamos el servicio para devolver un Optional con la factura
        when(facturaServicioMock.getFacturaByID(idBuscado)).thenReturn(Optional.of(factura));
        
        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/facturas/{id}", idBuscado))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id_factura", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.precio", Matchers.is(19990)));
    }
}
