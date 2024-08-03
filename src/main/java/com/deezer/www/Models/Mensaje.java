package com.deezer.www.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_mensajes")
@Data
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_mensaje")
    private int codigo_mensaje;
    @Column(name = "fecha_enviado")
    private Date fecha_enviado;
    @Column(name = "contenido")
    private String contenido;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "codigo_usuario_emisor",referencedColumnName = "codigo_usuario")
    private Usuario emisor;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "codigo_receptor",referencedColumnName = "codigo_usuario")
    private Usuario receptor;     
}
