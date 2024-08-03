package com.deezer.www.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "tbl_usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private int codigo_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name="foto_perfil")
    private String foto_perfil;
    @Column(name = "fecha_de_nacimiento")
    private Date fecha_de_nacimiento;
    @Column(name = "fecha_registro")
    private Date fecha_registro;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "correo")
    private String correo;
   /* @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Contrato_x_usuario> contratos; */
    @ManyToOne
    @JoinColumn(name = "codigo_tipo_usuario",referencedColumnName = "codigo_tipo")
    @JsonManagedReference
    private Tipo_usuario tipo_usuario;
    @ManyToOne
    @JoinColumn(name = "codigo_genero",referencedColumnName = "codigo_genero")
    @JsonManagedReference
    private Genero_Persona genero;
    @OneToMany(mappedBy = "emisor")
    @JsonBackReference
    private List<Mensaje> menajesemisor;
    @OneToMany(mappedBy = "receptor")
    @JsonBackReference
    private List<Mensaje> menajesreceptor;
    @ManyToOne
    @JoinColumn(name = "codigo_contrato",referencedColumnName = "codigo_contrato")
    @JsonBackReference
    private Contrato_x_usuario contratos_x_usuario;

    /* reformular el modelo relacional, un usuario solo puede estar sucrito a un plan a la vez por lo cual se
     * debe modificar la relaciones referentes a los contratos y los usuarios  
     */
    }
