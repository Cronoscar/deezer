package com.deezer.www.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import java.util.List;
@Entity
@Table(name = "tbl_generos_personas")
@Data
public class Genero_Persona {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo_genero_persona")
    private int codigo_genero;
    @Column(name = "tipo_genero")
    private String tipo_genero;
    @OneToMany(mappedBy = "genero")
    @JsonManagedReference("genero_reference")
    private List<Usuario> usuarios;
    @OneToMany(mappedBy = "genero_persona_artista")
    @JsonManagedReference("genero_persona_artistas")
    private List<Artista> artistas;
}
