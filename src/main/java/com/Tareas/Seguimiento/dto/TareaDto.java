package com.Tareas.Seguimiento.dto;

import com.Tareas.Seguimiento.model.Tarea;

public class TareaDto {

    private Long Id;
    private String Titulo;
    private String Contenido;
    private String grupoName;
    private String usuarioName;
    private Long idUsu;
    private Long idGru;
    private Boolean Completado;

    //region Contructores
    public TareaDto(Tarea tarea) {
    }

    //endregion

    //region setter y getters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getGrupoName() {
        return grupoName;
    }

    public void setGrupoName(String grupoName) {
        this.grupoName = grupoName;
    }

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public Boolean getCompletado() {
        return Completado;
    }

    public void setCompletado(Boolean completado) {
        Completado = completado;
    }

    //endregion
}
