package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.dto.UsuarioDto;
import com.Tareas.Seguimiento.service.impl.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/seguimiento")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping(path = "/agregarUsuario")
    public void addNewUsuario(@RequestBody UsuarioDto usuario){
        usuarioService.addNewUsuario(usuario);
    }
    @DeleteMapping(path = "/eliminarTarea/{Usuarioid}")
    public void removeUsuario(@PathVariable Long Usuarioid){
        usuarioService.deleteUsuario(Usuarioid);
    }

}
