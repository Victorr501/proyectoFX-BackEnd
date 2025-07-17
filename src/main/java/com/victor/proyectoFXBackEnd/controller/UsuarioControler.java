package com.victor.proyectoFXBackEnd.controller;

import com.victor.proyectoFXBackEnd.DTO.Login;
import com.victor.proyectoFXBackEnd.DTO.UsuarioDTO;
import com.victor.proyectoFXBackEnd.model.Usuario;
import com.victor.proyectoFXBackEnd.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControler {
    private final UsuarioService service;

    public UsuarioControler(UsuarioService service){
        this.service = service;
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioDTO> getUserByEmail(@PathVariable String correo){
        return service.getUsuarioPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody UsuarioDTO usuarioDTO){
        boolean existo = service.registrar(usuarioDTO);
        if (existo){
            return ResponseEntity.ok("Usuario registrado con exito");
        } else {
            return ResponseEntity.badRequest().body("El correo ya existe");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
        Optional<UsuarioDTO> usuarioDTO = service.getUsuarioPorCorreo(login.getCorreo());
        if (usuarioDTO.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encotrado");
        }

        boolean esValido = service.verificarContraseña(usuarioDTO.get(), login.getContrasena());

        if (!esValido) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok("Login correcto");
    }
}
