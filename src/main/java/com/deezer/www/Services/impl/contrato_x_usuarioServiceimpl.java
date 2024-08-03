package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Contrato_x_usuario;
import com.deezer.www.Repositorys.contrato_x_usuarioRepository;
import com.deezer.www.Services.contrato_x_usuarioService;
@Service
public class contrato_x_usuarioServiceimpl implements contrato_x_usuarioService{

    @Autowired
    private contrato_x_usuarioRepository contrato_x_usuarioRepository;
    @Override
    public List<Contrato_x_usuario> obtenertodosloscontratosxusuarios() {
        return this.contrato_x_usuarioRepository.findAll();
    }
    
}
