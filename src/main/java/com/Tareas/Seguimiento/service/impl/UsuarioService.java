package com.Tareas.Seguimiento.service.impl;

import com.Tareas.Seguimiento.dto.UsuarioDto;
import com.Tareas.Seguimiento.model.Usuario;
import com.Tareas.Seguimiento.repository.IUsuarioRepository;
import com.Tareas.Seguimiento.service.IUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    public UsuarioService() {
    }

    public UsuarioService(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

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

    @Override
    public Boolean authenticate(String username, String password) {

        Usuario usuario = iUsuarioRepository.findByName(username);
        if (usuario != null) {
            String user = usuario.getName();
            String pass = usuario.getPassword();

            if (user.equals(username) && pass.equals(password)) {
                // Inicio de sesión exitoso
                return true;
            }
        }
        return false;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        iUsuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return iUsuarioRepository.findAll();
    }
}
