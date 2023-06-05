package com.Tareas.Seguimiento.config;

import com.Tareas.Seguimiento.model.Usuario;
import com.Tareas.Seguimiento.repository.IUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class UsuarioConfig {
    @Bean("Usuario")
    CommandLineRunner commandLineRunner(IUsuarioRepository UsuarioRepository) {
        return args -> {
            Usuario Dennis = new Usuario(
                    "Dennis",
                    "hola"
            );
            Usuario Hector = new Usuario(
                    "Hector",
                    "hola2"
            );
            UsuarioRepository.saveAll(
                    Arrays.asList(Dennis, Hector)
            );
        };

    }
}
