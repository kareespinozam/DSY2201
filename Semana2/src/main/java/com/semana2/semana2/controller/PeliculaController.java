package com.semana2.semana2.controller;
import org.springframework.web.bind.annotation.*;

import com.semana2.semana2.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculaController {
    private List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaController(){
        peliculas.add(new Pelicula(1, "Blade Runner 2049", 2017, "Denis Villeneuve", "Ciencia Ficción", "Tras la rebelión de los replicantes creados por bioingeniería para ser utilizados como mano de obra esclava y la prohibición a Tyrell Corporation de seguir con su fabricación, el empresario Niander Wallace adquirió lo que quedaba de Tyrell Corp. y creó una nueva línea de replicantes mucho más obedientes. Ahora, en el año 2049, los viejos modelos Nexus 8 que continúan con vida están siendo retirados. Los que les persiguen aún reciben el nombre de Blade Runner."));
        peliculas.add(new Pelicula(2, "Pulp Fiction", 1994, "Quentin Tarantino", "Crimen", "Historias de dos matones, un boxeador y una pareja de atracadores de poca monta envueltos en una violencia espectacular e irónica."));
        peliculas.add(new Pelicula(3, "Fight Club", 1999, "David Fincher", "Drama", "Un empleado de oficina insomne en busca de una manera de cambiar su vida se cruza con un vendedor y crean un club de lucha clandestino como forma de terapia."));
        peliculas.add(new Pelicula(4, "Akira", 1988, "Katsuhiro Otomo", "Anime/Ciencia Ficción", "Neo-Tokio, año 2019. Tras un extraño accidente, el joven Tetsuo es sometido a experimentos secretos para controlar la mente."));
        peliculas.add(new Pelicula(5, "La La Land", 2016, "Damien Chazelle", "Musical", "Mia y Sebastian son dos jóvenes que quieren abrirse camino en el mundo de Hollywood. Mia es una joven aspirante a actriz que trabaja como camarera mientras acude a castings y Sebastian toca el piano en bares. Un día sus caminos se cruzan e inmediatamente se enamoran. Los dos trabajan juntos para hacer realidad sus sueños, pero pronto se dan cuenta de que el mundo del arte pide sacrificios que ponen en peligro su relación."));
    }

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas(){
        return peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getStudentById(@PathVariable int id){
        for (Pelicula p : peliculas){
            if (p.getId()== id){
                return p;
            }
        }
        return null;
    }
    
}