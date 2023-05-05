package com.Tareas.Seguimiento.repository;

import com.Tareas.Seguimiento.dto.GrupoDto;
import com.Tareas.Seguimiento.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGrupoRepository extends JpaRepository<Grupo, Long> {
    Optional<Grupo> findByName(String nombre);
}
