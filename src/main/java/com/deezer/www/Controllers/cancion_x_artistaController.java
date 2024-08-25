package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Cancion_X_Artista;
import com.deezer.www.Services.impl.cancion_x_artistaServiceimpl;
@RestController
@RequestMapping("/artistas/canciones")
public class cancion_x_artistaController {
    @Autowired
    private cancion_x_artistaServiceimpl cancion_x_artistaServiceimpl;
    @GetMapping("/todas")
    public List<Cancion_X_Artista> obtenertodas(){
        return this.cancion_x_artistaServiceimpl.todoslosCancion_X_Artistas();
    }
}
