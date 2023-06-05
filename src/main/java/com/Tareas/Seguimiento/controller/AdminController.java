package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.Utils.JwtTokenUtil;
import com.Tareas.Seguimiento.dto.AdminDto;
import com.Tareas.Seguimiento.service.impl.AdministradorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/seguimiento")

public class AdminController {

    private AdministradorService administradorService;
    private static final Logger log = LogManager.getLogger(AdminController.class);

    JwtTokenUtil jwtTokenUtil;
    @PostMapping(path = "/agregarAdmin")
    public void addNewAdmin(@RequestBody AdminDto admin){
//        boolean authorized = jwtTokenUtil.validateToken(token);
//        if (authorized == false){
//            log.error("no estas autorizado");
//        }
        administradorService.addNewAdmin(admin);
    }
    @DeleteMapping(path = "/eliminarAdmin/{Adminid}")
    public void removeAdmin(@PathVariable Long Adminid){
        administradorService.deleteAdmin(Adminid);
    }

}
