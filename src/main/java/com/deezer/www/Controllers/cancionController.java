package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Cancion;
import com.deezer.www.Services.impl.cancionServiceimpl;

@RestController
@RequestMapping("/canciones")
public class cancionController {
    @Autowired
    private cancionServiceimpl cancionServiceimpl;

    @GetMapping("/todas")
    public List<Cancion> todaslascanciones(){

        return this.cancionServiceimpl.obtenertodasCanciones();
    }
    
}
