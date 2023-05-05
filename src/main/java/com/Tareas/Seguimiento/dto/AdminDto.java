package com.Tareas.Seguimiento.dto;

public class AdminDto {

    private Long Id;
    private String Name;

    //region constructores

    public AdminDto() {
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
