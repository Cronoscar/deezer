package com.deezer.www.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deezer.www.Models.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findBycorreo(String correo);
    
}
