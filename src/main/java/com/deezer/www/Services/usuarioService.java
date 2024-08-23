package com.deezer.www.Services;

import java.util.List;

import com.deezer.www.Models.Usuario;

public interface usuarioService {
    public List<Usuario> obtenertodosUsuarios();
    public String nuevoUsuario(Usuario nuevUsuario);
    public Usuario obtenerUsuarioporID(int codigo_usuario);
    public Usuario obtenerUsuarioporcorreo(String correo);
}
