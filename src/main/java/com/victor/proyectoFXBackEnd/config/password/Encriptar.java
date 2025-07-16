package com.victor.proyectoFXBackEnd.config.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encriptar {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //Hashea la contraseña para guardarla en la base de datos
    public String encodePassword(String rawPassword){
        return encoder.encode(rawPassword);
    }

    //Comprueba la base de datos
    public boolean matches(String rawPassword, String encodedPassword){
        return encoder.matches(rawPassword, encodedPassword);
    }
}
