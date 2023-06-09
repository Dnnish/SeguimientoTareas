package com.Tareas.Seguimiento.config;

import com.Tareas.Seguimiento.model.Tarea;
import com.Tareas.Seguimiento.repository.ITareaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TareaConfig {
    @Bean("Tarea")
    CommandLineRunner commandLineRunner(ITareaRepository iTareaRepository){

        return args -> {
            Tarea Wildfly = new Tarea(
                    "Estudiar Wildfly 17",
                    "Cosistas gente",
                    1L,
                    1L,
                    false
            );
            Tarea Spring = new Tarea(
                    "Practicar Spring",
                    "El framework de spring en un primer momento es complicado pero con la practica se vuelve mas sencillo",
                    2L,
                    2L,
                    false
            );
            Tarea python = new Tarea(
                    "Estudiar python",
                    "Es un leguaje sencillo muy adaptado al lenguaje humano :)",
                    1L,
                    2L,
                    false
            );
            iTareaRepository.saveAll(
                    Arrays.asList(Wildfly, Spring, python)
            );
        };
    }
}
