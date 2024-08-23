package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Genero_Musical;
import com.deezer.www.Repositorys.genereros_musicalesRepository;
import com.deezer.www.Services.genero_musicalService;
@Service
public class genero_musicalsServiceimpl  implements genero_musicalService{

    @Autowired 
    private genereros_musicalesRepository genereros_musicalesRepository;
    @Override
    public List<Genero_Musical> obtener_Generos_Musicales() {
    return this.genereros_musicalesRepository.findAll();
    }
    
}
