package com.Tareas.Seguimiento.service;

import com.Tareas.Seguimiento.dto.GrupoDto;

public interface IGrupoService {
    void addNewGrupo(GrupoDto grupoDto);

    void deleteGrupo(Long idGrupo);
}
