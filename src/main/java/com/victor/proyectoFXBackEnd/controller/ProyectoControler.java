package com.victor.proyectoFXBackEnd.controller;

import com.victor.proyectoFXBackEnd.DTO.ProyectoDTO;
import com.victor.proyectoFXBackEnd.DTO.complementos.ProyectoCrear;
import com.victor.proyectoFXBackEnd.service.ProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoControler {
    private ProyectoService pS;

    public ProyectoControler (ProyectoService ps){
        this.pS = ps;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody ProyectoCrear proyectoCrear){
        if (proyectoCrear.getProyectoDTO() == null && proyectoCrear.getId_usuario() == null){
            return ResponseEntity.badRequest().body("Faltan datos obligatorios");
        }

        boolean creado = pS.crearProyecto(proyectoCrear.getProyectoDTO(), proyectoCrear.getId_usuario());

        if (!creado){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un proyecto con ese nombre");

        }
        return ResponseEntity.ok("Proyecto creado perfectamente");
    }
}
