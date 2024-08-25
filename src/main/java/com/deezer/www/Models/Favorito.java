package com.deezer.www.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_favoritos")
@Data
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_favorito")
    private int codigo_favorito;
    @ManyToOne
    @JoinColumn(name="codigo_usuario",referencedColumnName = "codigo_usuario")
    private Usuario usuario;
    @ManyToOne
   
    @JoinColumn(name="codigo_cancion",referencedColumnName = "codigo_cancion")
    private Cancion cancion;
    @ManyToOne
    @JoinColumn(name="codigo_album",referencedColumnName = "codigo_album")
    private Album album;
}
