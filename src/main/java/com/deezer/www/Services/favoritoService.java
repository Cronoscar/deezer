package com.deezer.www.Services;

import java.util.List;

import com.deezer.www.DTO.fav;
import com.deezer.www.Models.Favorito;


public interface favoritoService {

    public String nuevoFavorito(fav nFav);
     List<Favorito> getFavoritosByCodigoUsuario(Integer codigoUsuario);
    
}
