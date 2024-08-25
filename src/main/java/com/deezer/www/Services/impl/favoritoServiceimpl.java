package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.DTO.fav;
import com.deezer.www.Models.Artista;
import com.deezer.www.Models.Cancion;
import com.deezer.www.Models.Favorito;
import com.deezer.www.Models.Usuario;
import com.deezer.www.Repositorys.cancionRepository;
import com.deezer.www.Repositorys.favoritoRepository;
import com.deezer.www.Repositorys.usuarioRepository;
import com.deezer.www.Services.favoritoService;
@Service
public class favoritoServiceimpl implements favoritoService {
    @Autowired 
    favoritoRepository favoritoRepository;
    @Autowired
    usuarioRepository usuarioRepository;
    @Autowired 
    cancionRepository cancionRepository;
    @Override
    public String nuevoFavorito(fav nFav) {
        Favorito guardar= new Favorito();
        Cancion nueCancion=new Cancion();
        Usuario nUsuario= new Usuario();
        nueCancion =this.cancionRepository.findById(nFav.getCodigo_cancion()).get();
        nUsuario= this.usuarioRepository.findById(nFav.getCodigo_usuario()).get();
        guardar.setCancion(nueCancion);
        guardar.setUsuario(nUsuario);
        guardar.setAlbum(null);

        

         this.favoritoRepository.save(guardar);
         return "favorito guardado";
    }
    @Override
    public List<Favorito> getFavoritosByCodigoUsuario(Integer codigoUsuario) {
        
        return this.favoritoRepository.findByCodigoFavorito(codigoUsuario);
    }
    
    
}
