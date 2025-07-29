package com.victor.proyectoFXBackEnd.mapper.proyecto.tareaTitulo;

import com.victor.proyectoFXBackEnd.DTO.proyecto.tareaTitulo.TareaDTO;
import com.victor.proyectoFXBackEnd.model.proyecto.tareaTitulo.Tarea;
import com.victor.proyectoFXBackEnd.model.proyecto.TareaTitulo;
import org.springframework.stereotype.Component;

@Component
public class MapperTarea {
    public TareaDTO tareaTOTareaDTO(Tarea t){
        TareaDTO dto = new TareaDTO();
        dto.setId(t.getId());
        dto.setContendio(t.getContenido());
        dto.setCompletada(t.isCompletada());
        dto.setFechaLimite(t.getFechaLimite());
        dto.setPrioridad(t.getPriodidad());
        dto.setTareaTituloId(t.getTareaTitulo().getId());
        return dto;
    }

    public Tarea tareaDTOTOTarea(TareaDTO dto){
        Tarea t = new Tarea();
        t.setId(dto.getId());
        t.setContenido(dto.getContendio());
        t.setPriodidad(dto.getPrioridad());
        t.setCompletada(dto.isCompletada());
        t.setFechaLimite(dto.getFechaLimite());
        if (dto.getTareaTituloId() != null){
            TareaTitulo tT = new TareaTitulo();
            tT.setId(dto.getTareaTituloId());
            t.setTareaTitulo(tT);
        }
        return t;
    }
}
