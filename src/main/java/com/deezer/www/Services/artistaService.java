package com.deezer.www.Services;

import java.util.List;

import com.deezer.www.Models.Artista;

public interface artistaService {

    public List<Artista> obtenertodosArtistas();
    public String crearArtista(Artista nuevoArtista);
    public Artista obtenerArtistaporID(int codigo_artista);
}
