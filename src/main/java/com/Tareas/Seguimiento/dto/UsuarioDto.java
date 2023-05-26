package com.Tareas.Seguimiento.dto;

import com.Tareas.Seguimiento.model.Usuario;

public class UsuarioDto {

    private Long Id;
    private String Name;

    //region Constructores

    public UsuarioDto(Usuario usuario){
    }
    public UsuarioDto() {
    }


    public UsuarioDto(Long id, String name) {
        Id = id;
        Name = name;
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

    //endregion
}
