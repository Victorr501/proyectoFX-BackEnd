package com.victor.proyectoFXBackEnd.controller;

import com.victor.proyectoFXBackEnd.DTO.complementos.DocumentoCrear;
import com.victor.proyectoFXBackEnd.DTO.proyecto.DocumentoDTO;
import com.victor.proyectoFXBackEnd.model.proyecto.Documento;
import com.victor.proyectoFXBackEnd.service.DocumentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {
    private final DocumentoService dS;

    public DocumentoController(DocumentoService dS){
        this.dS = dS;
    }

    @GetMapping("proyecto/{proyectoId}")
    public DocumentoDTO getDocuementoPorProyecto(@PathVariable Integer proyectoId){
        return dS.obtenerDocumentosPorProyectos(proyectoId);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@PathVariable DocumentoCrear dc){
        if (dc.getDto() == null && dc.getId_proyecto() == null){
            return ResponseEntity.badRequest().body("Faltan datos obligatorios");
        }

        boolean creado = dS.crearDocumento(dc.getDto(), dc.getId_proyecto());

        if (!creado){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error al crear");
        }

        return ResponseEntity.ok("Proyecto creado perfectamente");
    }
}
