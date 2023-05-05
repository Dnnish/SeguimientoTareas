package com.Tareas.Seguimiento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tar_codtar")
    private Long IdTarea;
    @Column(name = "tar_titol")
    private String Titulo;
    @Column(name = "tar_contenido")
    private String Contenido;
    @Column(name = "tar_codusu")
    private Long idUsu;

    @Column(name = "tar_codgru")
    private Long idGru;

    private Boolean Completado = false;


    //region contructores
    public Tarea() {
    }
    public Tarea(Long idTarea, String titulo, String contenido, Long idUsu, Long idGru, Boolean Completado) {
        IdTarea = idTarea;
        Titulo = titulo;
        Contenido = contenido;
        this.idUsu = idUsu;
        this.idGru = idGru;
        this.Completado = Completado;
    }

    public Tarea(String titulo, String contenido, Long idUsu, Long idGru, Boolean Completado) {
        Titulo = titulo;
        Contenido = contenido;
        this.idUsu = idUsu;
        this.idGru = idGru;
        this.Completado = Completado;
    }
    //endregion

    //region setter y getters

    public Long getIdTarea() {
        return IdTarea;
    }

    public void setIdTarea(Long idTarea) {
        IdTarea = idTarea;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public Long getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Long idUsu) {
        this.idUsu = idUsu;
    }

    public Long getIdGru() {
        return idGru;
    }

    public void setIdGru(Long idGru) {
        this.idGru = idGru;
    }

    public Boolean getCompletado() {
        return Completado;
    }

    public void setCompletado(Boolean completado) {
        Completado = completado;
    }

    //endregion
}
