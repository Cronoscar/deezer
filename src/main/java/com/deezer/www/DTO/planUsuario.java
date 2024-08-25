package com.deezer.www.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class planUsuario {

    private int codigo_plan;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int coidigo_perido;
    
}
