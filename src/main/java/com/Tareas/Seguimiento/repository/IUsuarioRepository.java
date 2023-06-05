package com.Tareas.Seguimiento.repository;

import com.Tareas.Seguimiento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByName(String Name);
}
