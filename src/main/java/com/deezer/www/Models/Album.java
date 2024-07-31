package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "albumes")
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_album")
    private int codigo_album;
    @Column(name = "nombre_album")
    private String nombre_album;
    @Column(name = "cantidad_canciones")
    private int cantidad_canciones;
    @Column(name = "portada")//cambiar el tipo en el modelo relacional de sql developer
    private String portada;
}
