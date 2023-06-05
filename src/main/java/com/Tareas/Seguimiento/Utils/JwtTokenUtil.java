package com.Tareas.Seguimiento.Utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import static javax.accessibility.AccessibleRole.HEADER;
import static org.thymeleaf.spring6.dialect.SpringStandardDialect.PREFIX;

@Component
public class JwtTokenUtil implements HandlerInterceptor {

    private static final Logger log = LogManager.getLogger(JwtTokenUtil.class);
    // private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; // 24h
    private String encodeSecretKey;

    /**
     * Se usa para inicializar un token y no tener que generar constantemente uno nuevo
     */
    @PostConstruct
    public void init() {
        encodeSecretKey = Base64.getEncoder().encodeToString(SECRET_KEY.getEncoded());
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

//    @Override
//    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String requestURI = request.getRequestURI();
//        if (isPublicEndpoint(requestURI)) {
//            // La página es un endpoint público, continuar con la solicitud
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = extractToken(request);
//        if (token == null) {
//            // El token es nulo, enviar una respuesta de error o redireccionar a una página de inicio de sesión
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acceso no autorizado");
//            return;
//        }
//        // validacion
//        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//        if(token != null){
//            try {
//                Claims claims = Jwts.parser()
//                        .setSigningKey(SECRET_KEY)
//                        .parseClaimsJws(token)
//                        .getBody();
//                if (isAuthorized(claims)){
//                    filterChain.doFilter(request, response);
//                }else {
//                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acceso no autorizado");
//                }
//
//            }catch (JwtException e) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acceso no autorizado");
//            }
//        }else {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acceso no autorizado");
//        }
//    }

//    private boolean isPublicEndpoint(String requestURI) {
//        // Verificar si el endpoint es público (por ejemplo, "/vista/login")
//        return requestURI.equals("/vista/login") || requestURI.equals("/vista/Postlogin") || requestURI.equals("/seguimiento/velidoToken");
//    }

    public boolean validateToken(String tokenBearer) {
        String token = extractToken(tokenBearer);
        if (token != null && !token.equals("")) {
            try {
                Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
                log.info("Token dentro de validation : " + token);
                return true;
            } catch (Exception e) {
                log.info("Token dentro de validation pero false : " + token);
                return false;
            }
        }
        log.info("No entro en el validation el token: " + token);
        return false;
    }

    public String extractToken(String tokenCliente) {
        if (tokenCliente != null && tokenCliente.startsWith("Bearer ")) {
            return tokenCliente.substring(7); // Eliminar "Bearer " para obtener solo el token
        }
        return null;
    }
}