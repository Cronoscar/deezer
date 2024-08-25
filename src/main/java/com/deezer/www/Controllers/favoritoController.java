package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.DTO.fav;
import com.deezer.www.Models.Favorito;
import com.deezer.www.Services.impl.favoritoServiceimpl;

@RestController
@RequestMapping("/favoritos")
public class favoritoController {
    @Autowired
    private favoritoServiceimpl favoritoServiceimpl;
    @PostMapping("/new")
    public String guardar(@RequestBody fav nFav){
        return this.favoritoServiceimpl.nuevoFavorito(nFav);
    }
    @GetMapping("/obtener/{codigo_usuario}")
    public List<Favorito> favoritosxUsarios (@PathVariable int codigo_usuario){
        return this.favoritoServiceimpl.getFavoritosByCodigoUsuario(codigo_usuario);
    }
}
