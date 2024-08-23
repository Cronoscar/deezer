package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;
@Entity
@Table(name = "tbl_preferencias_musicales")
@Data
public class Preferencia_Musical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_preferencia") 
    private int codigo_preferencia;
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;
    @ManyToOne
    @JoinColumn(name="codigo_usuario",referencedColumnName = "codigo_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="codigo_artista",referencedColumnName = "codigo_artista")
    private Artista artista;
    @ManyToOne
    @JoinColumn(name="codigo_genero",referencedColumnName = "codigo_genero")
    private Genero_Musical genero_musical;
}
