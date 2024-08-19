package com.deezer.www.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deezer.www.Models.Usuario;
import com.deezer.www.Repositorys.usuarioRepository;
import com.deezer.www.Services.usuarioService;
@Service
public class usuarioServiceimpl implements usuarioService {
    @Autowired
    private usuarioRepository usuarioRepository;
    @Override
    public List<Usuario> obtenertodosUsuarios() {
        return this.usuarioRepository.findAll();    
    }
    @Override
    public String nuevoUsuario(Usuario nuevUsuario) {
    if(this.usuarioRepository.existsById(nuevUsuario.getCodigo_usuario())){

        return "Usuario ya existe";
    } else 
    {
        this.usuarioRepository.save(nuevUsuario);    
        return "se agrego "+" " + nuevUsuario.getNombre() +" " +"de manera correcta";
    }
    }
    @Override
    public Usuario obtenerUsuarioporID(int codigo_usuario) {
        if(this.usuarioRepository.existsById(codigo_usuario)){
            return this.usuarioRepository.findById(codigo_usuario).get();
        }else{
            return null;
        }
    }
    
}
