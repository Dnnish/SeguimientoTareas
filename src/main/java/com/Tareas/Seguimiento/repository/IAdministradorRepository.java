package com.Tareas.Seguimiento.repository;

import com.Tareas.Seguimiento.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByName(String nombre);
}
