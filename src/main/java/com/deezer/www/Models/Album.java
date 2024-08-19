package com.deezer.www.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tbl_albumes")
@Data
public class Album {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_album")
    private int codigo_album;
    @Column(name = "nombre_album")
    private String nombre_album;
    @Column(name = "cantidad_canciones")
    private int cantidad_canciones;
    @Column(name = "portada")//cambiar el tipo en el modelo relacional de sql developer
    private String portada;
    @ManyToOne 
    @JoinColumn(name = "codigo_discografica",referencedColumnName = "codigo_discografica")
    @JsonBackReference("discografia_album_reference")
    private Discografica discografica;
    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private List<Favorito> favoritos;
}
