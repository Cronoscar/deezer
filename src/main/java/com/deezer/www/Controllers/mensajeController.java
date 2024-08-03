package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Mensaje;
import com.deezer.www.Services.impl.mensajeServiceimpl;

@RestController
@RequestMapping("/mensajes")
public class mensajeController {
    
    @Autowired
    private mensajeServiceimpl mensajeServiceimpl;

    @GetMapping("/todos")
    public List<Mensaje> obtenertodoslosmensajes(){
        return this.mensajeServiceimpl.obtenertodoslosmensajes();
    }
}
