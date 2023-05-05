package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.dto.AdminDto;
import com.Tareas.Seguimiento.service.impl.AdministradorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/seguimiento")
public class AdminController {

    private AdministradorService administradorService;

    @PostMapping(path = "/agregarAdmin")
    public void addNewAdmin(@RequestBody AdminDto admin){
        administradorService.addNewAdmin(admin);
    }
    @DeleteMapping(path = "/eliminarAdmin/{Adminid}")
    public void removeAdmin(@PathVariable Long Adminid){
        administradorService.deleteAdmin(Adminid);
    }

}
