package com.Tareas.Seguimiento.service.impl;

import com.Tareas.Seguimiento.dto.GrupoDto;
import com.Tareas.Seguimiento.model.Grupo;
import com.Tareas.Seguimiento.repository.IGrupoRepository;
import com.Tareas.Seguimiento.service.IGrupoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService implements IGrupoService {
    @Autowired
    private IGrupoRepository iGrupoRepository;

    @Override
    public void addNewGrupo(GrupoDto grupoDto) {
        Grupo grupo = new Grupo();
        grupo.setIdgrupos(grupoDto.getIdgrupos());
        grupo.setName(grupoDto.getName());
        iGrupoRepository.save(grupo);
    }

    @Override
    public void deleteGrupo(Long idGrupo) {
        Grupo grupo = iGrupoRepository.findById(idGrupo).orElse(null);
        if (grupo != null) {
            iGrupoRepository.delete(grupo);
        } else {
            throw new EntityNotFoundException("Grupo con id: " + idGrupo + " no ha encontrado");
        }
    }

}
