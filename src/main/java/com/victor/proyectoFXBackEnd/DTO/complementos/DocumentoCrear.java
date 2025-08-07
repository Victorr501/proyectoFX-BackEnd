package com.victor.proyectoFXBackEnd.DTO.complementos;

import com.victor.proyectoFXBackEnd.DTO.proyecto.DocumentoDTO;

public class DocumentoCrear {
    private DocumentoDTO dto;
    private Integer id_proyecto;

    public DocumentoCrear() {
    }

    public DocumentoDTO getDto() {
        return dto;
    }

    public void setDto(DocumentoDTO dto) {
        this.dto = dto;
    }

    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
}
