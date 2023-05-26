package com.Tareas.Seguimiento.service;

import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.model.Tarea;

import java.util.List;

public interface ITareaService {

    List<TareaDto> getTarea();
    List<TareaDto> getTareaByUsuarioId(Long UsuarioId);
    List<TareaDto> getTareaByAdministradorAndGrupo(Long AdminId, Long GrupoId);

//    void addNewTarea(TareaDto tareaDto);

    void addNewTarea(TareaDto tareaDto);

    void deleteTarea(Long idtarea);

    Tarea marcarTarea(Long idTarea);

//    Tarea desmarcarTareaComoCompletada(Long idTarea);
}
