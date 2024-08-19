package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "tbl_canciones_x_artistas")
@Data
public class Cancion_X_Artista {
    @Id
    //
    @Column(name = "codigo_c_x_a")
    private int codigo_c_x_a;
    @ManyToOne
    @JoinColumn(name =  "codigo_cancion",referencedColumnName = "codigo_cancion")
    private Cancion cancion;
    @ManyToOne
    @JoinColumn(name =  "codigo_artista",referencedColumnName = "codigo_artista")
    private Artista artista;
    
}
