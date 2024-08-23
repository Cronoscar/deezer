package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Cancion;
import com.deezer.www.Repositorys.cancionRepository;
import com.deezer.www.Services.cancionService;
@Service
public class cancionServiceimpl implements cancionService {
    @Autowired
    private cancionRepository cancionRepository;
    @Override
    public List<Cancion> obtenertodasCanciones() {
    
        return this.cancionRepository.findAll();
    }
    
}
