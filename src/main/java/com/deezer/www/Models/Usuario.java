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
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "codigo_tipo_usuario",referencedColumnName = "codigo_tipo_usuario")
    @JsonBackReference ("tipousuarioreference")
    private Tipo_usuario tipo_usuario;
    @ManyToOne
    @JoinColumn(name = "codigo_genero_persona",referencedColumnName = "codigo_genero_persona")
    @JsonBackReference("genero_reference")
    private Genero_Persona genero;
    @OneToMany(mappedBy = "emisor")
    @JsonManagedReference("emisor_reference")
    @JsonIgnore
    private List<Mensaje> menajesemisor;
    @OneToMany(mappedBy = "receptor")
    @JsonManagedReference("receptor_reference")
    @JsonIgnore
    private List<Mensaje> menajesreceptor;
    
    @ManyToOne
    @JoinColumn(name =  "codigo_plan",referencedColumnName = "codigo_plan")
    @JsonBackReference ("plan_reference")
    private Plan plan;
    }
