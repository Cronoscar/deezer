package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Mensaje;
import com.deezer.www.Repositorys.mensajeRepository;
import com.deezer.www.Services.mensajeService;
@Service
public class mensajeServiceimpl implements mensajeService {
    @Autowired
    private mensajeRepository mensajeRepository;
    @Override
    public List<Mensaje> obtenertodoslosmensajes() {
    
        return this.mensajeRepository.findAll();
        
    }
    
}
