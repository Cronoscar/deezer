package com.deezer.www.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deezer.www.Models.Mensaje;

public interface mensajeRepository extends JpaRepository<Mensaje,Integer>{
    
}
