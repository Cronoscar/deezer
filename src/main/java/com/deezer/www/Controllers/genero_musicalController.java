package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Genero_Musical;
import com.deezer.www.Services.impl.genero_musicalsServiceimpl;

@RestController
@RequestMapping("/generos/musicales")
public class genero_musicalController {
    @Autowired
    private genero_musicalsServiceimpl genero_musicalsServiceimpl;

    @GetMapping("/todos")
    public List<Genero_Musical> obtenertodosGenerosMusicales (){
       return this.genero_musicalsServiceimpl.obtener_Generos_Musicales();
    }
}
