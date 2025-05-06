package com.facturacion.facturacion.controller;

import static org.mockito.Mockito.when;

import java.util.List;
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
    private FacturaServicelmpl eventoServicioMock;

    @Test
    public void obetenerTodosTest() throws Exception{
        // Arrange
        Factura evento1 = new Factura();
        evento1.setPrecio(19990);
        evento1.setId_factura(1L);
        Factura evento2 = new Factura();
        evento2.setPrecio(69420);
        evento2.setId_factura(2L);
        List<Factura> facturacion = Arrays.asList(evento1,evento2);
        when(eventoServicioMock.getAllFacturas()).thenReturn(facturacion);
        
        //Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/facturacion"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.aMapWithSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.eventoList[0].evento",Matchers.is(19990)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.eventoList[1].evento",Matchers.is(69420))
                );

    }

}
