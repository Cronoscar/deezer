package com.deezer.www.Models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

@Entity
@Table(name = "tbl_contratos_x_usuarios")
@Data
public class Contrato_x_usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_contrato")
    private int codigo_contrato;
    @Column(name = "fecha_inicio")
    private Date fecha_inicio;
    @Column(name = "fecha_fin")
    private Date fecha_fin;
  /*   @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "codigo_usuario",referencedColumnName = "codigo_usuario")
    private Usuario usuario;
    */
    @OneToMany(mappedBy = "contratos_x_usuario")
    @JsonManagedReference
    private List<Usuario> usuarios;
/*   @ManyToOne
    @JoinColumn(name = "codigo_sucripcion",referencedColumnName = "codigo_sucripcion")
    private Sucripcion sucripcion;
    @ManyToOne
    @JoinColumn(name="codigo_periodo",referencedColumnName="codigo_periodo")
    private Periodo periodo;
    */
}
