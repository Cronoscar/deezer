package com.deezer.www.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.DTO.Preferencia;
import com.deezer.www.Models.Artista;
import com.deezer.www.Models.Preferencia_Musical;
import com.deezer.www.Models.Usuario;
import com.deezer.www.Repositorys.artistaRepository;
import com.deezer.www.Repositorys.cancionRepository;
import com.deezer.www.Repositorys.preferencia_musicalRepository;
import com.deezer.www.Repositorys.usuarioRepository;
import com.deezer.www.Services.preferencia_musicalService;
@Service
public class preferencia_musicalServiceimpl implements preferencia_musicalService {
    @Autowired
    private preferencia_musicalRepository preferencia_musicalRepository;
    @Autowired
    private usuarioRepository usuarioRepository;
    @Autowired 
    private artistaRepository artistaRepository;
    @Override
    public String nuevapreferencia_musical(Preferencia nuevaPreferencia_Musical) {
        Preferencia_Musical nPreferencia_Musical=new Preferencia_Musical();
        
        nPreferencia_Musical=prueba(nuevaPreferencia_Musical);
        nPreferencia_Musical.setFecha_creacion(nuevaPreferencia_Musical.getFecha_creacion());
        this.preferencia_musicalRepository.save(nPreferencia_Musical);
        return "se guardo preferencia";
        
    }
    @Override
    public Preferencia_Musical prueba(Preferencia nPreferencia) {

        
    Preferencia_Musical nuevapreferencia=new Preferencia_Musical();
    Artista nueArtista=new Artista();
    Usuario nUsuario= new Usuario();
    nueArtista=this.artistaRepository.findById(nPreferencia.getCodigo_artista()).orElseThrow(() -> new RuntimeException("Artista no encontrado"));
    nUsuario=this.usuarioRepository.findById(nPreferencia.getCodigo_usuario()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));;
    nuevapreferencia.setArtista(nueArtista);
    nuevapreferencia.setUsuario(nUsuario);
    return nuevapreferencia ;
    }
    
}
