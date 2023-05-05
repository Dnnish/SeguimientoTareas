package com.Tareas.Seguimiento.service.impl;

import com.Tareas.Seguimiento.dto.UsuarioDto;
import com.Tareas.Seguimiento.model.Usuario;
import com.Tareas.Seguimiento.repository.IUsuarioRepository;
import com.Tareas.Seguimiento.service.IUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public void addNewUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setIdUsu(usuarioDto.getId());
        usuario.setName(usuarioDto.getName());
        iUsuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long idUsuario) {
        Usuario usuario = iUsuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            iUsuarioRepository.delete(usuario);
        } else {
            throw new EntityNotFoundException("Usuario con id: " + idUsuario + " no ha encontrado");
        }
    }
}
