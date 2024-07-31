package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;
import java.util.Date;

@Entity
@Table(name = "discograficas")
@Data
public class Discografica {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo_discografica")
    private int codigo_discografica;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cantidad_artistas")
    private int cantidad_artistas;
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

}
