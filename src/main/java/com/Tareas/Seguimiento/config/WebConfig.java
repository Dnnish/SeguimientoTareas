package com.Tareas.Seguimiento.config;

import com.Tareas.Seguimiento.Utils.JwtTokenUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final JwtTokenUtil jwtTokenUtil;

    public WebConfig(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenUtil)
                .addPathPatterns("/**")
                .excludePathPatterns("/vista/login"); // Excluir el endpoint público de la validación del token
    }
}