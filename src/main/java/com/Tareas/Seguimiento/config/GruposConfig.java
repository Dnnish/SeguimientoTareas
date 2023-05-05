package com.Tareas.Seguimiento.config;

import com.Tareas.Seguimiento.model.Grupo;
import com.Tareas.Seguimiento.repository.IGrupoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class GruposConfig {
    @Bean("Grupos")
    CommandLineRunner commandLineRunner(IGrupoRepository grupoRepository){

        return args -> {
            Grupo Acceso = new Grupo(
                    "Acceso a datos",
                    1L
            );
            Grupo Sistemas = new Grupo(
                    "Sistemas",
                    2L
            );
            Grupo Programacion = new Grupo(
                    "Programacion",
                    2L
            );
            grupoRepository.saveAll(
                    Arrays.asList(Acceso, Programacion,Sistemas)
            );
        };
    }
}
