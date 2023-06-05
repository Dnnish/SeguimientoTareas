package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.Utils.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seguimiento")
class TokenController {
    @Autowired
    JwtTokenUtil jwtTokenUtil;

//    @GetMapping("/validoToken")
//    public boolean ValidationController(HttpServletRequest request) {
//        return jwtTokenUtil.validateToken(jwtTokenUtil.extractToken(request));
//    }
}
