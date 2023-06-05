package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.Utils.JwtTokenUtil;
import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.model.Tarea;
import com.Tareas.Seguimiento.model.Usuario;
import com.Tareas.Seguimiento.repository.IUsuarioRepository;
import com.Tareas.Seguimiento.service.impl.TareaService;
import com.Tareas.Seguimiento.service.impl.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/vista")
public class ThymeleafController {

    private static final Logger log = LogManager.getLogger(JwtTokenUtil.class);
    private TareaService tareaService;
    private UsuarioService usuarioService;

    private JwtTokenUtil jwtTokenUtil;

    public ThymeleafController(TareaService tareaService, UsuarioService usuarioService, JwtTokenUtil jwtTokenUtil) {
        this.tareaService = tareaService;
        this.usuarioService = usuarioService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public List<TareaDto> getTareas() {
        return tareaService.getTarea();
    }

    public List<TareaDto> getTareasByUsuarioId(Long UsuarioId) {
        return tareaService.getTareaByUsuarioId(UsuarioId);
    }

    public List<TareaDto> getTareasByAdminAndGrupo(Long AdminId, Long GrupoId) {
        return tareaService.getTareaByAdministradorAndGrupo(AdminId, GrupoId);
    }

//    @GetMapping(path = "/Tareas")
//    public String TodasLasTareas(Model model){
//        model.addAttribute("posts", this.getTareas());
//        return "index";
//    }

    //Index
    @GetMapping(path = "/inicio")
    public ModelAndView inicioTareas(Model model, @RequestParam("Bearer") String token) {
        boolean authorized = jwtTokenUtil.validateToken(token);
        if (authorized == false){
            log.error("no estas autorizado");
        }
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("Usuario", new Usuario());
        modelAndView.addObject("posts", this.getTareas());
        return modelAndView;
    }

    // Usuario
    @GetMapping(path = "/Usuario")
    public ModelAndView getUsuarioIndividual(@RequestParam(defaultValue = "1", name = "id", required = false) Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("Usuario");

        model.addAttribute("usuario", new Usuario());
        List<TareaDto> TareaFiltradoList = this.getTareasByUsuarioId(id);

        modelAndView.addObject("TareaList", TareaFiltradoList);
        return modelAndView;
    }

    // Admin
    @GetMapping(path = "/Admin/Grupo")
    public ModelAndView getAdminGrupo(@RequestParam(required = false, defaultValue = "1") Long AdminId, @RequestParam(required = false, defaultValue = "1") Long GrupoId) {
        ModelAndView modelAndview = new ModelAndView("Admin");

        List<TareaDto> GrupoFiltrado = this.getTareasByAdminAndGrupo(AdminId, GrupoId);
        modelAndview.addObject("GrupoList", GrupoFiltrado);
        return modelAndview;
    }

    //Registro de usuarios

    @GetMapping(path = "/Usuario/Registro")
    public ModelAndView getRegistro() {
        ModelAndView modelAndView = new ModelAndView("Registro");

        return modelAndView;
    }

    //funcionalidades
    @PutMapping("/{id}/completado")
    public ResponseEntity<TareaDto> marcarTarea(@PathVariable Long id) {
        Tarea tarea = tareaService.marcarTarea(id);

        if (tarea == null) {
            return ResponseEntity.notFound().build();
        } else {
            TareaDto tareaDto = new TareaDto(tarea);
            return ResponseEntity.ok(tareaDto);
        }
    }


//    @PostMapping(path = "/crear")
//    public String crearUsuario(@ModelAttribute("tarea") Usuario usuario, BindingResult result) {
//        UsuarioDto usuarioDto = new UsuarioDto();
//        usuarioDto.setName(usuarioDto.getName());
//        usuarioService.addNewUsuario(usuarioDto);
//        return "redirect:/vista/Usuario";
//    }

    @PostMapping(path = "/crearTarea")
    public ResponseEntity<TareaDto> crearTarea(@RequestBody TareaDto tareaDto) {
        tareaService.addNewTarea(tareaDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(tareaDto);
    }

    @PostMapping(path = "/eliminar/{Tareaid}")
    public String removeTarea(@PathVariable Long Tareaid) {
        tareaService.deleteTarea(Tareaid);
        return "redirect:/vista/Usuario";
    }

    @GetMapping("/usuario/crear")
    public String mostrarFormularioRegistro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "Registro";
    }

    @GetMapping("/usuario/lista")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "lista-usuarios";
    }


}
