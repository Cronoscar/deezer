package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Usuario;
import com.deezer.www.Repositorys.usuarioRepository;
import com.deezer.www.Services.usuarioService;
@Service
public class usuarioServiceimpl implements usuarioService {
    @Autowired
    private usuarioRepository usuarioRepository;
    @Override
    public List<Usuario> obtenertodosUsuarios() {
        return this.usuarioRepository.findAll();    
    }
    
}
