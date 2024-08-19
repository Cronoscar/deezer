package com.deezer.www.Models;

import java.util.Date;

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
@Table(name = "tbl_usuarios_x_playlist")
@Data
public class Usuario_x_Playlist {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_u_x_p")
    private int codigo_u_x_p;

    @Column(name = "fecha_union")
    private Date fecha_union;

    @ManyToOne
    @JoinColumn(name="codigo_usuario",referencedColumnName = "codigo_usuario")
    private Usuario Usuario;
    
    @ManyToOne
    @JoinColumn(name="codigo_playlist",referencedColumnName = "codigo_playlist")
    private Playlist playlist;
}
