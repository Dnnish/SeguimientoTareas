package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.model.Tarea;
import com.Tareas.Seguimiento.model.Usuario;
import com.Tareas.Seguimiento.service.impl.TareaService;
import com.Tareas.Seguimiento.service.impl.UsuarioService;
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

    private TareaService tareaService;
    private UsuarioService usuarioService;

    public ThymeleafController(TareaService tareaService, UsuarioService usuarioService) {
        this.tareaService = tareaService;
        this.usuarioService = usuarioService;
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
    public ModelAndView inicioTareas() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts", this.getTareas());
        return modelAndView;
    }

    // Usuario
    @GetMapping(path = "/Usuario")
    public ModelAndView getUsuarioIndividual(@RequestParam(defaultValue = "1", name = "id", required = false) Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("Usuario");
        model.addAttribute("Usuario", new Usuario());
        List<TareaDto> TareaFiltradoList = this.getTareasByUsuarioId(id);

        modelAndView.addObject("TareaList", TareaFiltradoList);
        return modelAndView;
    }

    // Admin
    @GetMapping(path = "/Admin/Grupo")
    public ModelAndView getAdminGrupo(@RequestParam (required = false, defaultValue = "1") Long AdminId, @RequestParam (required = false, defaultValue = "1") Long GrupoId) {
        ModelAndView modelAndview = new ModelAndView("Admin");

        List<TareaDto> GrupoFiltrado = this.getTareasByAdminAndGrupo(AdminId, GrupoId);
        modelAndview.addObject("GrupoList", GrupoFiltrado);
        return modelAndview;
    }

    //Registro de usuarios

    @GetMapping(path = "/Usuario/Registro")
    public ModelAndView getRegistro(){
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

    //    @DeleteMapping("/eliminarTarea/{Tareaid}")
//    public String removeTarea(@PathVariable Long Tareaid) {
//        tareaService.deleteTarea(Tareaid);
//        return "redirect:/vista/inicio";
//    }
//    @DeleteMapping(path = "/eliminar/{Tareaid}")
//    public void removeTarea(@PathVariable Long Tareaid){
//        System.out.println("id de la tarea: " + Tareaid);
//        tareaService.deleteTarea(Tareaid);
//    }

//    @GetMapping("/usuario/crear")
//    public String crearUsuario(Model model) {
//        model.addAttribute("usuario1", new Usuario());
//        return "redirect:/vista/Admin/Grupo";
//    }

    @GetMapping("/usuario/crear")
//    public String procesarCreacionUsuario(@ModelAttribute("usuario") Usuario usuario,
//                                          BindingResult result, Model model) {
//        if(result.hasErrors()) {
//            return "redirect:/vista/Usuario/Registro";
//        }
//        usuarioService.guardarUsuario(usuario);
//        model.addAttribute("usuario", new Usuario());
//        return "redirect:/vista/Admin/Grupo";
//    }
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
