package com.eventos.eventos.service;

import com.eventos.eventos.model.Evento;
import java.util.List;
import java.util.Optional;
public interface EventoService {
    List<Evento> getAllEventos();
    Optional<Evento> getEventoByID(Long id);

    //CRUD
    Evento createEvento(Evento evento);
    Evento updateEvento(Long id, Evento evento);
    void deleteEvento(Long id);
}
