package com.victor.proyectoFXBackEnd.mapper.proyecto;

import com.victor.proyectoFXBackEnd.DTO.proyecto.DocumentoDTO;
import com.victor.proyectoFXBackEnd.model.proyecto.Documento;
import com.victor.proyectoFXBackEnd.model.Proyecto;
import org.springframework.stereotype.Component;

@Component
public class MapperDocumentos {
    public DocumentoDTO documentoToDocumentoDTO(Documento d){
        DocumentoDTO documentoDTO = new DocumentoDTO();
        documentoDTO.setId(d.getId());
        documentoDTO.setTitulo(d.getTitulo());
        documentoDTO.setContenido(d.getContenido());
        documentoDTO.setProyectoId(d.getProyecto().getId());
        return documentoDTO;
    }

    public Documento documentoDTOToDocuemnto(DocumentoDTO d){
        Documento documento = new Documento();
        documento.setId(d.getId());
        documento.setContenido(d.getContenido());
        documento.setTitulo(d.getTitulo());
        if (d.getProyectoId() != null){
            Proyecto proyecto = new Proyecto();
            proyecto.setId(d.getProyectoId());
            documento.setProyecto(proyecto);
        }
        return documento;
    }
}
