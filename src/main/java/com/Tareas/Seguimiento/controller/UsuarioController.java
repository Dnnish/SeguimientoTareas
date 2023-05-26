package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.dto.UsuarioDto;
import com.Tareas.Seguimiento.service.impl.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/seguimiento")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

//    @PostMapping(path = "/agregarUsuario")
//    public void addNewUsuario(@RequestBody UsuarioDto usuario){
//        usuarioService.addNewUsuario(usuario);
//    }
    @DeleteMapping(path = "/eliminarUsuario/{Usuarioid}")
    public void removeUsuario(@PathVariable Long Usuarioid){
        usuarioService.deleteUsuario(Usuarioid);
    }

    @PostMapping(path = "/crearUsuario")
    public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody UsuarioDto usuarioDto){
        usuarioService.addNewUsuario(usuarioDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
    }
}
