package com.Tareas.Seguimiento.dto;

public class GrupoDto {
    private Long idgrupos;
    private String name;
    private Long administradorId;

    //region setter y getters

    public Long getIdgrupos() {
        return idgrupos;
    }

    public void setIdgrupos(Long idgrupos) {
        this.idgrupos = idgrupos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAdministradorId() {
        return administradorId;
    }

    public void setAdministradorId(Long administradorId) {
        this.administradorId = administradorId;
    }

    //endregion
}
