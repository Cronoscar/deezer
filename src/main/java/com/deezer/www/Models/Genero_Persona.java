package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
@Entity
@Table(name = "tbl_generos_personas")
@Data
public class Genero_Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo_genero")
    private int codigo_genero;
    @Column(name = "tipo_genero")
    private String tipo_genero;
}
