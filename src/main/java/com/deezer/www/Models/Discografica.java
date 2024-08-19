package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_discograficas")
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
    @OneToMany(mappedBy = "discografica")
    @JsonManagedReference("discografica_artista")
    private List<Artista> artistas;
    @OneToMany(mappedBy = "discografica")
    @JsonManagedReference("discografica_Cancion")
    private List<Cancion> canciones;
}
