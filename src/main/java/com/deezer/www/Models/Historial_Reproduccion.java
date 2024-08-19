package com.deezer.www.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_historial_reproduciones")
@Data

public class Historial_Reproduccion {
    @Id
    //
    @Column(name = "codigo_historial")
    private int codigo_historial;
    @Column(name = "tiempo_reproduccion")
    private Date tiempo_reproduccion;
    @ManyToOne
    @JoinColumn(name="codigo_usuario",referencedColumnName = "codigo_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="codigo_cancion",referencedColumnName = "codigo_cancion")
    private Cancion cancion;
}
