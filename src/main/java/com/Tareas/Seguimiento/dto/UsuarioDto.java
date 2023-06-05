package com.Tareas.Seguimiento.dto;

import com.Tareas.Seguimiento.model.Usuario;

public class UsuarioDto {

    private Long Id;
    private String Name;
    private String Pass;

    //region Constructores

    public UsuarioDto(Usuario usuario){
    }
    public UsuarioDto() {
    }


    public UsuarioDto(Long id, String name, String pass) {
        Id = id;
        Name = name;
        Pass = pass;
    }

    public UsuarioDto(String name) {
        Name = name;
    }
    //endregion

    //region setters y getters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getPass() {
        return Pass;
    }
    public void setPass(String pass){
        Pass = pass;
    }
    //endregion
}
