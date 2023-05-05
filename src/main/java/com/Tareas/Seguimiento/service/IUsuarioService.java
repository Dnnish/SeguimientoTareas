package com.Tareas.Seguimiento.service;

import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.dto.UsuarioDto;

public interface IUsuarioService {

    void addNewUsuario(UsuarioDto usuarioDto);

    void deleteUsuario(Long idTarea);
}
