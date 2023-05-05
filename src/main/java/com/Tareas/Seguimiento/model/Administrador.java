package com.Tareas.Seguimiento.model;

import jakarta.persistence.*;

@Entity
@Table(name="Administradores")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adm_codadm")
    private Long idAdmin;
    @Column(name="adm_name")
    private String name;

    //region Constructor

    public Administrador() {
    }

    public Administrador(Long idAdmin, String name) {
        this.idAdmin = idAdmin;
        this.name = name;
    }

    public Administrador(String name) {
        this.name = name;
    }

    //endregion

    //region getters y setters

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //endregion
}
