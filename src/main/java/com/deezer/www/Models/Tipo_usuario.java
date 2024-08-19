package com.deezer.www.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_tipo_usuarios")
@Data
public class Tipo_usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tipo_usuario")
    private int codigo_tipo_usuario;
    @Column(name = "tipo_usuario")
    private String tipo_usuario;
    
    @OneToMany(mappedBy = "tipo_usuario")
    @JsonBackReference
    private List<Usuario> usuarios;
}
