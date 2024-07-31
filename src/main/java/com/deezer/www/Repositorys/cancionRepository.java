package com.deezer.www.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deezer.www.Models.Cancion;

public interface cancionRepository extends JpaRepository<Cancion,Integer> {

    
    
}
