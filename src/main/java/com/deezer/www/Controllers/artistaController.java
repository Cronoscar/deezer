package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Artista;
import com.deezer.www.Services.impl.artistaServiceimpl;

@RestController
@RequestMapping("/Artistas")
public class artistaController {

    @Autowired
    private artistaServiceimpl artistaServiceimpl;
    @GetMapping("/todos")
    public List<Artista> obtenertodos(){

        return this.artistaServiceimpl.obtenertodosArtistas();
    } 

    @PostMapping("/crear")
    public String nuevoArtista( @RequestBody Artista nueArtista){
        return this.artistaServiceimpl.crearArtista(nueArtista);
    }
    @GetMapping("/obtener/{id}")
    public Artista obteneArtista(@PathVariable int id){
        return this.artistaServiceimpl.obtenerArtistaporID(id);
    }
}
