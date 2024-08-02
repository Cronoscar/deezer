package com.deezer.www.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_sucripciones")
@Data
public class Sucripcion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    @Column(name = "codigo_sucripcion")
    private int codigo_sucripcion;
    @Column(name = "tipo_sucripcion")
    private String tipo_suscripcion;
    @Column(name = "precio")
    private int precio;
}
