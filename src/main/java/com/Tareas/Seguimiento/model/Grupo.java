package com.Tareas.Seguimiento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gru_codgru")
    private Long idgrupos;
    @Column(name="gru_name")
    private String name;
    @Column(name="gru_codadm")
    private Long administradorId;

    //region Constructores
    public Grupo() {
    }

    public Grupo(Long idgrupos, String name, Long administradorId) {
        this.idgrupos = idgrupos;
        this.name = name;
        this.administradorId = administradorId;
    }

    public Grupo(String name, Long administradorId) {
        this.name = name;
        this.administradorId = administradorId;
    }
    //endregion

    //region setters y getters

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
