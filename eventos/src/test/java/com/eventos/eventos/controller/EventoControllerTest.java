package com.eventos.eventos.controller;

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

import com.eventos.eventos.controllers.EventosController;
import com.eventos.eventos.model.Evento;
import com.eventos.eventos.service.EventoServicelmpl;

@WebMvcTest(EventosController.class)
public class EventoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private EventoServicelmpl eventoServicioMock;

    @Test
    public void obetenerTodosTest() throws Exception{
        // Arrange
        Evento evento1 = new Evento();
        evento1.setEvento("Competencia de Agility Canino");
        evento1.setId_evento(1L);
        Evento evento2 = new Evento();
        evento2.setEvento("69° Feria de mascotas de Cerro Navia");
        evento2.setId_evento(2L);
        List<Evento> eventos = Arrays.asList(evento1,evento2);
        when(eventoServicioMock.getAllEventos()).thenReturn(eventos);
        
        //Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/eventos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.aMapWithSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.eventoList[0].evento",Matchers.is("Competencia de Agility Canino")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.eventoList[1].evento",Matchers.is("69° Feria de mascotas de Cerro Navia"))
                );

    }

}
