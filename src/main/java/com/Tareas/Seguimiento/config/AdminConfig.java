package com.Tareas.Seguimiento.config;

import com.Tareas.Seguimiento.model.Administrador;
import com.Tareas.Seguimiento.repository.IAdministradorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AdminConfig {
    @Bean("Admin")
    CommandLineRunner commandLineRunner(IAdministradorRepository AdminRepository) {
        return args -> {
            Administrador Qinxiu = new Administrador(
                    "Qinxiu"
            );

            Administrador Patxi = new Administrador(
                    "Patxi"
            );
            AdminRepository.saveAll(
                    Arrays.asList(Qinxiu,Patxi)
            );
        };

    }
}
