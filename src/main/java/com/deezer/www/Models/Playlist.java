package com.deezer.www.Models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_playlists")
@Data
public class Playlist {
    @Id
    //
    @Column(name = "codigo_playlist")
    private int codigo_playlist;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad_fans")
    private int cantidad_fans;
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;
    @ManyToOne
    @JoinColumn(name = "codigo_creador", referencedColumnName = "codigo_usuario")
    @JsonBackReference("usuario_creador_reference")
    private Usuario usuario_creador;
    @OneToMany(mappedBy = "playlist")
    @JsonIgnore
    private List<Usuario_x_Playlist> playlist_x_usuario;
    @OneToMany(mappedBy = "playlist")
    @JsonIgnore
    private List<Cancion_x_Playlist> cancion_x_Playlists;
}
