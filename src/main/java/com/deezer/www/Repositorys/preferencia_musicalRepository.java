package com.deezer.www.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deezer.www.Models.Preferencia_Musical;
import java.util.List;

public interface preferencia_musicalRepository extends JpaRepository<Preferencia_Musical,Integer> {

    @Query("SELECT p FROM Preferencia_Musical p WHERE p.usuario.codigo_usuario = :codigo_usuario")
    List<Preferencia_Musical> findByCodigoUsuario(@Param("codigo_usuario") Integer codigoUsuario);

    
}
