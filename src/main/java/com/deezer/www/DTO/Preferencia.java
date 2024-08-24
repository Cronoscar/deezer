package com.deezer.www.DTO;
import java.util.Date;
import lombok.Data;
@Data
public class Preferencia {

    private Date fecha_creacion;
    private int codigo_usuario;
    private int codigo_artista;
}
