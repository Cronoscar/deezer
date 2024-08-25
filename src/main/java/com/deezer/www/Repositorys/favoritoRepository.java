package com.deezer.www.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deezer.www.Models.Favorito;
import com.deezer.www.Models.Preferencia_Musical;

public interface favoritoRepository extends JpaRepository<Favorito,Integer> {

    
    @Query("SELECT p FROM Favorito p WHERE p.usuario.codigo_usuario = :codigo_usuario")
    List<Favorito> findByCodigoFavorito(@Param("codigo_usuario") Integer codigoUsuario);
    
}
