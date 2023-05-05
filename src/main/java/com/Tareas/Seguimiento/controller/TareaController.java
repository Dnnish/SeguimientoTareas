package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.model.Tarea;
import com.Tareas.Seguimiento.service.impl.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/seguimiento")
public class TareaController {
    private TareaService tareaService;

    public TareaController(TareaService tareaService){
        this.tareaService = tareaService;
    }

    // Conseguir todas las tareas
    @GetMapping(value ="/administrador/tareas")
    public List<TareaDto> getTareas(){
        return tareaService.getTarea();
    }

    // Consegir tareas de un usuario
    @GetMapping(value = "/tareas/usuario")
    public List<TareaDto> getTareaByUsuarioId(@RequestParam Long UsuarioId){
        return tareaService.getTareaByUsuarioId(UsuarioId);
    }

    // conseguir todas las tareas de un grupo
    @GetMapping(value = "/tareas/administrador/grupo")
    public List<TareaDto> getTareaByAdministradorAndGrupo(@RequestParam Long AdminId, Long Grupo){
        return tareaService.getTareaByAdministradorAndGrupo(AdminId, Grupo);
    }

    // crear o eliminar tareas
    @PostMapping(path = "/agregarTarea")
    public void addNewTarea(@RequestBody TareaDto tarea){
        tareaService.addNewTarea(tarea);
    }

    @DeleteMapping(path = "/eliminarTarea/{Tareaid}")
    public void removeTarea(@PathVariable Long Tareaid){
        tareaService.deleteTarea(Tareaid);
    }

    // marcar tareas si estan hechas o desmarcarlas
    @PutMapping("/{id}/completado")
    public ResponseEntity<TareaDto> marcarTareaComoCompletada(@PathVariable Long id){
        Tarea tarea = tareaService.marcarTareaComoCompletada(id);

        if (tarea == null){
            return ResponseEntity.notFound().build();
        } else {
            TareaDto tareaDto = new TareaDto(tarea);
            return ResponseEntity.ok(tareaDto);
        }
    }

    @PutMapping("/{id}/incompletado")
    public ResponseEntity<TareaDto> desmarcarTareaComoCompletada(@PathVariable Long id){
        Tarea tarea = tareaService.desmarcarTareaComoCompletada(id);

        if (tarea == null){
            return ResponseEntity.notFound().build();
        } else {
            TareaDto tareaDto = new TareaDto(tarea);
            return ResponseEntity.ok(tareaDto);
        }
    }
}
