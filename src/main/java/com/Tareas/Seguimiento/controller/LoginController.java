package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.Utils.JwtTokenUtil;
import com.Tareas.Seguimiento.repository.IUsuarioRepository;
import com.Tareas.Seguimiento.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/vista")
class LoginController {

    private final JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUsuarioService iUsuarioService;

    public LoginController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @PostMapping("/Postlogin")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password, RedirectAttributes redirectAttributes, Model model) {
        boolean authenticate = iUsuarioService.authenticate(username, password);

        if (authenticate) {
            String token = jwtTokenUtil.generateToken(username);

            System.out.println("Token generado: " + token);
            redirectAttributes.addFlashAttribute("token", token);
            model.addAttribute("token", token);

            // Redirigir a la página de inicio
            return "token";
        } else {
            // Credenciales inválidas
            return "redirect:/vista/login";
        }
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
