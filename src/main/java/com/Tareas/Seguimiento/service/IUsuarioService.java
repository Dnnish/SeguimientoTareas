package com.Tareas.Seguimiento.service;

import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.dto.UsuarioDto;
import com.Tareas.Seguimiento.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    void addNewUsuario(UsuarioDto usuarioDto);

    void deleteUsuario(Long idTarea);

    Boolean authenticate(String username, String password);

    void guardarUsuario(Usuario usuario);

    List<Usuario> obtenerTodosLosUsuarios();
}
