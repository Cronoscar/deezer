package com.deezer.www.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deezer.www.Models.Usuario;
import com.deezer.www.Services.impl.usuarioServiceimpl;

@RestController
@RequestMapping("/Usuarios")
public class usuarioController {
@Autowired
private usuarioServiceimpl usuarioServiceimpl;

@GetMapping("/todos")
public List<Usuario> obtenertodolosUsuarios(){

return this.usuarioServiceimpl.obtenertodosUsuarios();
}
@PostMapping("/crear")
public String nuevoUsuario (@RequestBody Usuario nUsuario){

return this.usuarioServiceimpl.nuevoUsuario(nUsuario);
}
@GetMapping("/{id}")
public Usuario obtenerUsuario (@PathVariable int id){

    return this.usuarioServiceimpl.obtenerUsuarioporID(id);
}
}
