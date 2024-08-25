package com.deezer.www.Models;

import java.util.Date;
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
import java.sql.Time;


@Entity
@Table(name = "tbl_canciones")
@Data
public class Cancion {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name="url")
    private String url;
    @Column(name="portada")
    private String portada;
    @ManyToOne
    @JoinColumn(name = "codigo_discografica",referencedColumnName = "codigo_discografica")
    @JsonBackReference("discografica_Cancion")
    private Discografica discografica;
    @ManyToOne
    @JoinColumn(name = "codigo_genero",referencedColumnName = "codigo_genero")
    @JsonBackReference("genero_musical_cancion")
    private Genero_Musical genero_Musical;
    @OneToMany(mappedBy = "Cancion")
    @JsonIgnore
    private List<Cancion_x_Playlist> cancion_x_Playlists;
    @OneToMany(mappedBy = "cancion")
    @JsonIgnore
    private List<Favorito> favoritos;
    
    @OneToMany(mappedBy = "cancion")
    @JsonIgnore
    private List<Historial_Reproduccion> historial_Reproducciones;
    @OneToMany(mappedBy = "cancion")
    @JsonIgnore
    private List<Cancion_X_Artista> cancion_X_Artistas;
}
