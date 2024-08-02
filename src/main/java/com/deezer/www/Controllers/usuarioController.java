package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Usuario;
import com.deezer.www.Services.impl.usuarioServiceimpl;

@RestController
@RequestMapping("/Usuarios")
public class usuarioController {
    @Autowired
     private usuarioServiceimpl usuarioServiceimpl;

     @GetMapping("/todos")
     public List<Usuario> obtenertodolosUsuarios(){

        return this.usuarioServiceimpl.obtenertodosUsuarios();
     }
}
