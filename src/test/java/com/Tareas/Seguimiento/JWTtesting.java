package com.Tareas.Seguimiento;

import com.Tareas.Seguimiento.Utils.JwtTokenUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.Base64;

@SpringBootTest
class JWTtesting {

    private static final Logger log = LogManager.getLogger(JWTtesting.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Test
    void generateKey() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64EncodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        System.out.println("Generated Key: " + base64EncodedKey);
    }

    @Test
    void test() {
        System.out.println(jwtTokenUtil.generateToken("hello"));
    }

//    @Test
//    void Token_validation_test() {
//        // Arrange
//        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String base64EncodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
//        //Act
//        Boolean token = Token_validation(base64EncodedKey);
//        //Assert
//        Assertions.assertTrue(token);
//        log.info(token);
//    }

//    Boolean Token_validation(String token) {
//        if (token != null) {
//            Boolean validado = jwtTokenUtil.validateToken(token);
//            if(validado == true){
//                return true;
//            }
//            return false;
//        } else {
//            return false;
//        }
//    }
}
