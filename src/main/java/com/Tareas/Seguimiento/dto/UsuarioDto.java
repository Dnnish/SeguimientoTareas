package com.Tareas.Seguimiento.dto;

public class UsuarioDto {

    private Long Id;
    private String Name;

    //region Constructores

    public UsuarioDto() {
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
