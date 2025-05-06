package com.eventos.eventos.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.eventos.eventos.model.Evento;
import com.eventos.eventos.service.EventoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/eventos")
public class EventosController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public CollectionModel<EntityModel<Evento>> getAllEventos(){
        List<Evento> eventos = eventoService.getAllEventos();

        List<EntityModel<Evento>> eventoResources = eventos.stream()
                .map(evento -> EntityModel.of(evento,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEventosById(evento.getId_evento())).withSelfRel()
                    ))
                .collect(Collectors.toList());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos());
        CollectionModel<EntityModel<Evento>> resources = CollectionModel.of(eventoResources,linkTo.withRel("eventos"));

        return resources;
    }
    
    @GetMapping("/{id}")
    public EntityModel<Evento> getEventosById(@PathVariable Long id){
        Optional<Evento> evento = eventoService.getEventoByID(id);
        if (evento.isPresent()) {
            return EntityModel.of(evento.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEventosById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos()).withRel("all-eventos"));
        }else{
            throw new EventoNotFoundException("Evento no encontrado con id: " + id);
        }
    }
    //CRUD
    @PostMapping
    public EntityModel<Evento> createEvento(@RequestBody Evento evento){
        Evento createdEvento = eventoService.createEvento(evento);
        return EntityModel.of(createdEvento,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEventosById(createdEvento.getId_evento())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos()).withRel("all-eventos"));
    }

    @PutMapping("/{id}")
    public EntityModel<Evento> updateevento(@PathVariable Long id,@RequestBody Evento evento){
        Evento updatedEvento = eventoService.updateEvento(id, evento);
        return EntityModel.of(updatedEvento,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEventosById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEventos()).withRel("all-eventos"));
    }


    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id){
        eventoService.deleteEvento(id);
    }
}
