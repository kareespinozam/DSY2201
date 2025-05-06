package com.eventos.eventos.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.eventos.eventos.model.Evento;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EventoRepositoryTest {
    @Autowired
    private EventoRepository eventoRepository;

    @Test
    public void guardarEventoTest(){
        // Arrange
        Evento evento = new Evento();
        evento.setEvento("Competencia de Agility Canino");

        //Act
        Evento resultado = eventoRepository.save(evento);

        // Assert
        assertNotNull(resultado.getId_evento());
        assertEquals("Competencia de Agility Canino",resultado.getEvento());
    }
    // Otras pruebas
}
