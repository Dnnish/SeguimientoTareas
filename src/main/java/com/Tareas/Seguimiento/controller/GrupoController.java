package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.dto.GrupoDto;
import com.Tareas.Seguimiento.service.impl.GrupoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/seguimiento")
public class GrupoController {

    private GrupoService grupoService;

    @PostMapping(path = "/agregarGrupo")
    public void addNewGrupo(@RequestBody GrupoDto grupo){
        grupoService.addNewGrupo(grupo);
    }

    @DeleteMapping(path = "/eliminarGrupo/{Grupoid}")
    public void removeGrupo(@PathVariable Long Grupoid){
        grupoService.deleteGrupo(Grupoid);
    }
}
