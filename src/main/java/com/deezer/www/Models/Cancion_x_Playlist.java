package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_canciones_x_playlist")
@Data
public class Cancion_x_Playlist {
    
    @Id
    //
    @Column (name="codigo_c_x_p")
    private int codigo_c_x_p;
    @ManyToOne
    @JoinColumn(name="codigo_cancion",referencedColumnName = "codigo_cancion")
    private Cancion Cancion;
    
    @ManyToOne
    @JoinColumn(name="codigo_playlist",referencedColumnName = "codigo_playlist")
    private Playlist playlist;
}
