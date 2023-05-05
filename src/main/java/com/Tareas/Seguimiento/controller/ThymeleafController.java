package com.Tareas.Seguimiento.controller;

import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.model.Tarea;
import com.Tareas.Seguimiento.service.impl.TareaService;
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

    public ThymeleafController (TareaService tareaService){
        this.tareaService = tareaService;
    }

    public List<TareaDto> getTareas(){
        return tareaService.getTarea();
    }

    public List<TareaDto> getTareasByUsuarioId(Long UsuarioId){
        return tareaService.getTareaByUsuarioId(UsuarioId);
    }

    public List<TareaDto> getTareasByAdminAndGrupo(Long AdminId, Long GrupoId){
        return tareaService.getTareaByAdministradorAndGrupo(AdminId, GrupoId);
    }

    @GetMapping(path = "/Tareas")
    public String TodasLasTareas(Model model){
        model.addAttribute("posts", this.getTareas());
        return "index";
    }

    @GetMapping(path = "/inicio")
    public ModelAndView inicioTareas(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("posts",this.getTareas());
        return modelAndView;
    }

    @GetMapping(path = "/Usuario")
    public ModelAndView getUsuarioIndividual(@RequestParam(defaultValue = "1", name="id", required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("Usuario");

        List<TareaDto> TareaFiltradoList = this.getTareasByUsuarioId(id);

        modelAndView.addObject("TareaList", TareaFiltradoList);
        return modelAndView;
    }


    @GetMapping(path = "/Admin/Grupo")
    public ModelAndView getAdminGrupo(@RequestParam Long AdminId, Long GrupoId){
        ModelAndView modelAndview = new ModelAndView("Admin");

        List<TareaDto> GrupoFiltrado = this.getTareasByAdminAndGrupo(AdminId, GrupoId);
        modelAndview.addObject("GrupoList", GrupoFiltrado);
        return modelAndview;
    }

    @PutMapping("/{id}/completado")
    public ResponseEntity<TareaDto> marcarTarea(@PathVariable Long id){
        Tarea tarea = tareaService.marcarTarea(id);

        if (tarea == null){
            return ResponseEntity.notFound().build();
        } else {
            TareaDto tareaDto = new TareaDto(tarea);
            return ResponseEntity.ok(tareaDto);
        }
    }

    @PutMapping(path = "/eliminarTarea/{Tareaid}")
    public void removeTarea(@PathVariable Long Tareaid){
        tareaService.deleteTarea(Tareaid);
    }
}
