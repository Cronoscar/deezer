package com.deezer.www.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Preferencia_Musical;
import com.deezer.www.Repositorys.preferencia_musicalRepository;
import com.deezer.www.Services.preferencia_musicalService;
@Service
public class preferencia_musicalServiceimpl implements preferencia_musicalService {
    @Autowired
    private preferencia_musicalRepository preferencia_musicalRepository;
    @Override
    public String nuevapreferencia_musical(Preferencia_Musical nuevaPreferencia_Musical) {
        if (this.preferencia_musicalRepository.existsById(nuevaPreferencia_Musical.getCodigo_preferencia())) {
            return "preferencia ya existe";
        }else{
            this.preferencia_musicalRepository.save(nuevaPreferencia_Musical);
            return "se creo nueva preferencia " ;
        }
        
    }
    
}
