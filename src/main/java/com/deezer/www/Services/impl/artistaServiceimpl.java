package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Artista;
import com.deezer.www.Repositorys.artistaRepository;
import com.deezer.www.Services.artistaService;
@Service
public class artistaServiceimpl implements artistaService {

    @Autowired
    private artistaRepository artistaRepository;

    @Override
    public List<Artista> obtenertodosArtistas() {
        
        return this.artistaRepository.findAll();
    }

    @Override
    public String crearArtista(Artista nuevoArtista) {
       if (this.artistaRepository.existsById(nuevoArtista.getCodigo_artista())) {
         return "Artista ya existe";
       }else{
        this.artistaRepository.save(nuevoArtista);
            return "se guardo Artista "+" " +nuevoArtista.getNombre_artistico();

       }
    }

    
    
}
