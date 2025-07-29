package com.victor.proyectoFXBackEnd.mapper.proyecto;

import com.victor.proyectoFXBackEnd.DTO.proyecto.TareaTituloDTO;
import com.victor.proyectoFXBackEnd.model.Proyecto;
import com.victor.proyectoFXBackEnd.model.proyecto.TareaTitulo;
import org.springframework.stereotype.Component;

@Component
public class MapperTareaTitulo {
    public TareaTitulo tareaTituloDTOTOTareaTitulo(TareaTituloDTO dto){
        TareaTitulo t = new TareaTitulo();
        t.setId(dto.getId());
        t.setTitulo(dto.getTitulo());
        t.setDescripcion(dto.getDescripcion());
        if (dto.getProyectoId() != null){
            Proyecto p = new Proyecto();
            p.setId(dto.getProyectoId());
            t.setProyecto(p);
        }
        return t;
    }

    public TareaTituloDTO tareaTituloTOTareaTituloDTO(TareaTitulo t){
        TareaTituloDTO dto = new TareaTituloDTO();
        dto.setId(t.getId());
        dto.setTitulo(t.getTitulo());
        dto.setDescripcion(t.getDescripcion());
        dto.setProyectoId(t.getProyecto().getId());
        return dto;
    }
}
