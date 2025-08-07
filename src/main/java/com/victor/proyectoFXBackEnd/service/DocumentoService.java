package com.victor.proyectoFXBackEnd.service;

import com.victor.proyectoFXBackEnd.DTO.proyecto.DocumentoDTO;
import com.victor.proyectoFXBackEnd.mapper.proyecto.MapperDocumentos;
import com.victor.proyectoFXBackEnd.model.proyecto.Documento;
import com.victor.proyectoFXBackEnd.repository.DocumentosRepository;

public class DocumentoService {
    public MapperDocumentos mD;
    public DocumentosRepository dR;

    public DocumentoService(MapperDocumentos md, DocumentosRepository dR){
        this.mD = md;
        this.dR = dR;
    }

    public DocumentoDTO obtenerDocumentosPorProyectos(Integer id_proyecto){
        Documento d = dR.findbyProyectoId(id_proyecto);
        return mD.documentoToDocumentoDTO(d);
    }

    public Boolean crearDocumento(DocumentoDTO dto, Integer id_proyecto){
        dto.setProyectoId(id_proyecto);
        Documento d = mD.documentoDTOToDocuemnto(dto);
        try {
            dR.save(d);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
