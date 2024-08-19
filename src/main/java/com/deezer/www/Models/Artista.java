package com.deezer.www.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tbl_artistas")
@Data
public class Artista {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_artista")
    private int codigo_artista;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nombre_artistico")
    private String nombre_artistico;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fans")
    private int fans;
    @Column(name="foto_perfil")
    private String foto_perfil;
    @Column(name = "fecha_de_nacimiento")
    private Date fecha_de_nacimiento;
    @Column(name = "fecha_registro")
    private Date fecha_registro;
    @Column(name = "correo")
    private String correo;
    @Column(name = "cantidad_album")
    private int cantidad_album;
    @Column(name = "cantidad_canciones")
    private int cantidad_canciones;
    @Column(name="contrasena")
    private String contrasena;
    @ManyToOne 
    @JoinColumn (name = "genero_persona", referencedColumnName = "codigo_genero_persona")
    @JsonBackReference("genero_persona_artistas")
    private Genero_Persona genero_Persona_Artista;
    @ManyToOne
    @JoinColumn(name = "codigo_discografica",referencedColumnName = "codigo_discografica")
    @JsonBackReference("discografica_artista")
    private Discografica discografica;
}
