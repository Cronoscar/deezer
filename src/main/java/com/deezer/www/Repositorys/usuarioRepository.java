package com.deezer.www.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deezer.www.Models.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario,Integer> {


    
}
