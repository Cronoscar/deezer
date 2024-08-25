package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Cancion_X_Artista;
import com.deezer.www.Repositorys.cancion_x_artistaRepository;
import com.deezer.www.Services.cancion_x_artistaService;

@Service
public class cancion_x_artistaServiceimpl  implements cancion_x_artistaService{
    @Autowired
    private cancion_x_artistaRepository cancion_x_artistaRepository;
    @Override
    public List<Cancion_X_Artista> todoslosCancion_X_Artistas() {
        return this.cancion_x_artistaRepository.findAll();
    }
    
}
