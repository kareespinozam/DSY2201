package com.eventos.eventos.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.eventos.eventos.models.Evento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoController {
    private List<Evento> eventos = new ArrayList<>();

    public EventoController(){
        eventos.add(new Evento(1, "69° Feria de mascotas de Cerro Navia", LocalDate.parse("2025-04-20"), "Feria", 120, "¡Ven a conocer los nuevos emprendimientos orientados a mascotas, trae la tuya para que conozca a otros!", "Interespecie", "Cerro Navia"));
        eventos.add(new Evento(2, "Competencia de Agility Canino", LocalDate.parse("2025-05-10"), "Competición", 50,"Un evento para demostrar las habilidades de los perros en diferentes pruebas de agilidad. ¡Inscríbete y participa!","Perros", "Parque Metropolitano"));
        eventos.add(new Evento(3, "Exposición Internacional de Gatos", LocalDate.parse("2025-06-05"), "Exposición", 200,"Un evento exclusivo para amantes de los gatos, donde se presentan razas exóticas y se realizan concursos de belleza felina.","Gatos", "Centro de Convenciones Espacio Gato"));
        eventos.add(new Evento(4, "Encuentro de Adoptantes y Rescatistas", LocalDate.parse("2025-07-15"), "Encuentro", 100,"Jornada dedicada a promover la adopción de mascotas y compartir experiencias entre rescatistas y nuevos adoptantes.","Interespecie", "Plaza de Armas"));
        eventos.add(new Evento(5, "Maratón Canina 5K", LocalDate.parse("2025-08-12"), "Deportivo", 300,"Una carrera especial donde puedes correr junto a tu perro en un recorrido de 5 kilómetros. ¡Premios para los primeros lugares!","Perros", "Parque O'Higgins"));
        eventos.add(new Evento(6, "Exposición de Animales Exóticos", LocalDate.parse("2025-09-29"), "Exposición", 80,"Exposición de reptiles, insectos, aves y otras especies no convencionales. ¡Te invitamos a conocer más de la fauna poco común! ","Interespecie", "Parque Quinta Normal"));
        eventos.add(new Evento(7, "Operativo de esterilización", LocalDate.parse("2025-03-29"), "Operativo", 25,"Operativo para esterilizar a tu gato en un móvil municipal.","Gatos", "Plaza de Renca"));
        eventos.add(new Evento(8, "Feria de peluquería Canina", LocalDate.parse("2025-04-15"), "Feria", 100,"Invitamos a las mejores peluquerías caninas para que demuestren su experticie con los mejores peinados caninos, ¡No te lo pierdas!","Perros", "Casona de los diez"));
    }

    @GetMapping("/eventos")
    public List<Evento> getEventos(){
        return eventos;
    }

    @GetMapping("/eventos/{id_evento}")
    public Evento getEventoById(@PathVariable int id_evento){
        for (Evento f : eventos){
            if (f.getId_evento()== id_evento){
                return f;
            }
        }
        return null;
    }
}
