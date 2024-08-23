package com.deezer.www.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_generos_musicales")
@Data
public class Genero_Musical {
    @Id
//
    @Column(name = "codigo_genero")
    private int codigo_genero;
    @Column(name = "nombre_genero")
    private String Nombre_genero;
    @Column(name="descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "genero_Musical")
    @JsonManagedReference("genero_musical_cancion")
    @JsonIgnore
    private List<Cancion> canciones;
    @OneToMany(mappedBy = "genero_musical")
    @JsonIgnore
    private List<Preferencia_Musical> hPreferencia_Musicales;
    
}
