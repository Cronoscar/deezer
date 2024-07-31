package com.deezer.www.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "Canciones")
@Data
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cancion")
    private int codigo_cancion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_publicacion")
    private Date fecha_publicacion;
    @Column(name = "duracion")
    private Date duracion;
    @Column(name = "cantidad_favoritos")
    private int cantidad_favoritos;
}
