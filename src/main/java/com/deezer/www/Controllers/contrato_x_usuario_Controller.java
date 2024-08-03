package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Contrato_x_usuario;
import com.deezer.www.Services.impl.contrato_x_usuarioServiceimpl;
@RestController
@RequestMapping("/contratos")
public class contrato_x_usuario_Controller {
    @Autowired
    private contrato_x_usuarioServiceimpl contrato_x_usuarioServiceimpl;

    @GetMapping("/todos")
    public List<Contrato_x_usuario> obtenertodos(){

        return this.contrato_x_usuarioServiceimpl.obtenertodosloscontratosxusuarios();
    }
}
