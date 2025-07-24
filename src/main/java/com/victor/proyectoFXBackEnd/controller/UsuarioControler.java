package com.victor.proyectoFXBackEnd.controller;

import com.victor.proyectoFXBackEnd.DTO.complementos.CambiarContraseña;
import com.victor.proyectoFXBackEnd.DTO.complementos.Login;
import com.victor.proyectoFXBackEnd.DTO.UsuarioDTO;
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

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Integer id){
        return service.getUsuario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eleminarUsuario(@PathVariable Integer id){
        try {
            service.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario eliminado correctamente"); //204 No contend
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuaqrio no encotrado con ID: " + id);
        }
    }

    @PutMapping("/cambiar-password")
    public ResponseEntity<String> cambiarContrasena(@RequestBody CambiarContraseña cC){
        try {
            service.cambiarPassword(cC);
            return ResponseEntity.ok("Contraseña actualizada correctamente");
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO){
        if (!id.equals(usuarioDTO.getId())){
            return ResponseEntity.badRequest().body("Id del path y del cuerpo no coinciden");
        }

        try {
            String resultado = service.actualizarUsuario(usuarioDTO);
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
