package com.Tareas.Seguimiento.repository;

import com.Tareas.Seguimiento.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByIdUsu(long Id);
    @Query(value = "Select * FROM Tareas ta\n"+
            "LEFT JOIN Grupos grus ON ta.tar_codgru = grus.gru_codgru\n" +
            "LEFT JOIN Administradores A ON A.adm_codadm = grus.gru_codadm\n" +
            "WHERE A.adm_codadm = :adminId AND grus.gru_codgru = :grupoId", nativeQuery = true)
    List<Tarea> findByTareaByAdministradorAndGrupo(long adminId, long grupoId);

}
