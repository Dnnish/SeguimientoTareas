package com.Tareas.Seguimiento.service.impl;

import com.Tareas.Seguimiento.dto.TareaDto;
import com.Tareas.Seguimiento.model.Grupo;
import com.Tareas.Seguimiento.model.Tarea;
import com.Tareas.Seguimiento.model.Usuario;
import com.Tareas.Seguimiento.repository.IGrupoRepository;
import com.Tareas.Seguimiento.repository.ITareaRepository;
import com.Tareas.Seguimiento.repository.IUsuarioRepository;
import com.Tareas.Seguimiento.service.ITareaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService implements ITareaService {
    public TareaService(){
    }

    public TareaService(ITareaRepository iTareaRepository, IUsuarioRepository iUsuarioRepository, IGrupoRepository iGrupoRepository) {
        this.iTareaRepository = iTareaRepository;
        this.iUsuarioRepository = iUsuarioRepository;
        this.iGrupoRepository = iGrupoRepository;
    }

    @Autowired
    private ITareaRepository iTareaRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private IGrupoRepository iGrupoRepository;

    @Override
    public List<TareaDto> getTarea(){
        // request data
        List<Tarea> TareaList = iTareaRepository.findAll();
        List<TareaDto> TareaDtoList = new ArrayList<>();

        for (Tarea value : TareaList){
            long idgrupo = value.getIdGru();
            long idusuario = value.getIdUsu();

            Usuario usuario = iUsuarioRepository.findById(idusuario).orElse(null);
            Grupo grupo = iGrupoRepository.findById(idgrupo).orElse(null);

            //data mapping
            TareaDto tareaDto = toTareaDto(value, usuario, grupo);
            if(tareaDto != null){
                TareaDtoList.add(tareaDto);
            }
        }
        return TareaDtoList;
    }

    @Override
    public List<TareaDto> getTareaByUsuarioId(Long UsuarioId){
        Usuario usuario = iUsuarioRepository.findById(UsuarioId).orElse(null);

        List<Tarea> tareaList = iTareaRepository.findByIdUsu(UsuarioId);
        List<TareaDto> TareaDtoList = new ArrayList<>();

        for(Tarea value : tareaList){
            long GrupoId = value.getIdGru();
            Grupo grupo = iGrupoRepository.findById(GrupoId).orElse(null);

            TareaDto tareaDto = toTareaDto(value, usuario, grupo);
            if(tareaDto != null){
                TareaDtoList.add(tareaDto);
            }
        }
        return TareaDtoList;
    }
    @Override
    public List<TareaDto> getTareaByAdministradorAndGrupo(Long AdminId, Long GrupoId){
        Grupo grupo = iGrupoRepository.findById(GrupoId).orElse(null);

        List<Tarea> tareaList = iTareaRepository.findByTareaByAdministradorAndGrupo(AdminId, GrupoId);
        List<TareaDto> TareaDtoList = new ArrayList<>();

        for (Tarea value: tareaList){
            // data mapping
            Usuario usuario = iUsuarioRepository.findById(value.getIdUsu()).orElse(null);

            TareaDto tareaDto = toTareaDto(value, usuario, grupo);
            if(tareaDto != null){
                TareaDtoList.add(tareaDto);
            }
        }
        return TareaDtoList;
    }

    private TareaDto toTareaDto(Tarea tarea, Usuario usuario, Grupo grupo){

        if(tarea == null || usuario == null || grupo == null){
            return null;
        }
        TareaDto tareaDto = new TareaDto(tarea);
        tareaDto.setId(tarea.getIdTarea());
        tareaDto.setIdUsu(usuario.getIdUsu());
        tareaDto.setIdGru(grupo.getIdgrupos());
        tareaDto.setTitulo(tarea.getTitulo());
        tareaDto.setContenido(tarea.getContenido());
        tareaDto.setUsuarioName(usuario.getName());
        tareaDto.setGrupoName(grupo.getName());
        tareaDto.setCompletado(tarea.getCompletado());
        return tareaDto;
    }

    @Override
    public void addNewTarea(TareaDto tareaDto) {
        Tarea tarea = new Tarea();

        tarea.setTitulo(tareaDto.getTitulo());
        tarea.setContenido(tareaDto.getContenido());
        tarea.setIdUsu(tareaDto.getIdUsu());
        tarea.setIdGru(tareaDto.getIdGru());

        iTareaRepository.save(tarea);
    }

    @Override
    public void deleteTarea(Long idTarea) {
        Tarea tarea = iTareaRepository.findById(idTarea).orElse(null);
        if (tarea != null) {
            iTareaRepository.delete(tarea);
        } else {
            throw new EntityNotFoundException("tarea con id: " + idTarea + " no ha encontrado");
        }
    }
//    public void deleteTarea(Long Tareaid) {
//        iTareaRepository.deleteById(Tareaid);
//    }
    @Override
    public Tarea marcarTarea(Long idTarea){
        Tarea tarea = iTareaRepository.findById(idTarea).orElse(null);

        if (tarea != null || tarea.getCompletado() == false){
            tarea.setCompletado(true);
            return iTareaRepository.save(tarea);
        }else {
            tarea.setCompletado(false);
            return iTareaRepository.save(tarea);
        }
    }
//    @Override
//    public Tarea desmarcarTareaComoCompletada(Long idTarea){
//        Tarea tarea = iTareaRepository.findById(idTarea).orElse(null);
//
//        if (tarea != null){
//            tarea.setCompletado(false);
//            return iTareaRepository.save(tarea);
//        }else {
//            return null;
//        }
//    }
}