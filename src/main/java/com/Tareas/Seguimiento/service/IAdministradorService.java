package com.Tareas.Seguimiento.service;

import com.Tareas.Seguimiento.dto.AdminDto;

public interface IAdministradorService {
    void addNewAdmin(AdminDto adminDto);

    void deleteAdmin(Long idAdmin);
}
