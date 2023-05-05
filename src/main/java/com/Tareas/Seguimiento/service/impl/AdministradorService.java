package com.Tareas.Seguimiento.service.impl;

import com.Tareas.Seguimiento.dto.AdminDto;
import com.Tareas.Seguimiento.model.Administrador;
import com.Tareas.Seguimiento.repository.IAdministradorRepository;
import com.Tareas.Seguimiento.repository.IGrupoRepository;
import com.Tareas.Seguimiento.repository.ITareaRepository;
import com.Tareas.Seguimiento.repository.IUsuarioRepository;
import com.Tareas.Seguimiento.service.IAdministradorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService implements IAdministradorService {
    @Autowired
    private ITareaRepository iTareaRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private IGrupoRepository iGrupoRepository;

    @Autowired
    private IAdministradorRepository iAdministradorRepository;

    @Override
    public void addNewAdmin(AdminDto adminDto) {
        Administrador administrador = new Administrador();
        administrador.setIdAdmin(adminDto.getId());
        administrador.setName(adminDto.getName());
        iAdministradorRepository.save(administrador);
    }

    @Override
    public void deleteAdmin(Long idAdmin) {
        Administrador administrador = iAdministradorRepository.findById(idAdmin).orElse(null);
        if (administrador != null) {
            iAdministradorRepository.delete(administrador);
        } else {
            throw new EntityNotFoundException("Admin con id: " + idAdmin + " no ha encontrado");
        }
    }

}
