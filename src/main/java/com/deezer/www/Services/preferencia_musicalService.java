package com.deezer.www.Services;

import com.deezer.www.DTO.Preferencia;
import com.deezer.www.Models.Preferencia_Musical;
import java.util.List;
public interface preferencia_musicalService {

    public String nuevapreferencia_musical (Preferencia nuevaPreferencia_Musical);
    public Preferencia_Musical prueba (Preferencia nPreferencia);
    List<Preferencia_Musical> getPreferenciasByCodigoUsuario(Integer codigoUsuario);
    
}
