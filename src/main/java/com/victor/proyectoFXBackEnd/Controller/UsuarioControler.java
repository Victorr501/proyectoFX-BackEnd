package com.victor.proyectoFXBackEnd.Controller;

import com.victor.proyectoFXBackEnd.DTO.UsuarioDTO;
import com.victor.proyectoFXBackEnd.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
