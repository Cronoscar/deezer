package com.deezer.www.Models;

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
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "tbl_planes")
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_plan")
    private int codigo_plan;
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    @Column(name = "fecha_fin")
    private Date fecha_fin;
    @Column(name = "precio")
    private int precio;
    @ManyToOne
    @JoinColumn(name = "codigo_periodo",referencedColumnName = "codigo_periodo")
    @JsonManagedReference
    private Periodo periodo;
    @ManyToOne 
    @JoinColumn(name = "codigo_sucripcion",referencedColumnName = "codigo_sucripcion")
    @JsonManagedReference
    private Sucripcion sucripcion;
    @OneToMany(mappedBy = "plan")
    @JsonBackReference
    private List<Usuario> usuario;
}
