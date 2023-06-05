package com.Tareas.Seguimiento.model;

import jakarta.persistence.*;

@Entity
@Table(name="Usuarios")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_codusu")
    private Long idUsu;
    @Column(name="usu_name")
    private String name;
    @Column(name="usu_pass")
    private String password;
    /*@Column(name="usu_codadm")
    private Long idAdmin;*/
    //region Contructores
    public Usuario() {
    }
    public Usuario(Long idUsu, String name, String password) {
        this.idUsu = idUsu;
        this.name = name;
        this.password = password;
       // this.idAdmin = idAdmin;
    }
    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Usuario(String name) {
        this.name = name;
        //this.idAdmin = idAdmin;
    }
    //endregion

    //region setter y getters
    public Long getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Long idUsu) {
        this.idUsu = idUsu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }*/
    //endregion
}
