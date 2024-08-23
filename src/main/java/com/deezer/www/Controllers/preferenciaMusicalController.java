package com.deezer.www.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Preferencia_Musical;
import com.deezer.www.Services.impl.preferencia_musicalServiceimpl;

@RestController
@RequestMapping("/preferencias/musicales")
public class preferenciaMusicalController {
    @Autowired
    private preferencia_musicalServiceimpl preferencia_musicalServiceimpl;
    
    @PostMapping("/crear")
    public String nuevaPreferenciaMusical (@RequestBody Preferencia_Musical nPreferencia_Musical){
        return this.preferencia_musicalServiceimpl.nuevapreferencia_musical(nPreferencia_Musical);
    }
}
