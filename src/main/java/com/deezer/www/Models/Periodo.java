package com.deezer.www.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_periodos")
@Data
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_periodo")
    private int codigo_periodo;
    @Column(name = "tipo_periodo")
    private String tipo_periodo;//cambiar el tipo de dato en el modelo relacional 
    @OneToMany(mappedBy = "periodo")
    @JsonBackReference
    private List<Plan> planes;
    

}
