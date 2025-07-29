package com.victor.proyectoFXBackEnd.mapper.proyecto;

import com.victor.proyectoFXBackEnd.DTO.proyecto.EventosCalendarioDTO;
import com.victor.proyectoFXBackEnd.model.proyecto.EventosCalendario;
import com.victor.proyectoFXBackEnd.model.Proyecto;
import org.springframework.stereotype.Component;

@Component
public class MapperEventosCalendario {
    public EventosCalendarioDTO eventosCalendarioTOEventoCalendarioDTO(EventosCalendario e){
        EventosCalendarioDTO DTO = new EventosCalendarioDTO();
        DTO.setId(e.getId());
        DTO.setFecha(e.getFecha());
        DTO.setDescripcion(e.getDescripcion());
        DTO.setTitulo(e.getTitulo());
        DTO.setProyectoId(e.getProyecto().getId());
        return DTO;
    }

    public EventosCalendario eventosCalendarioDTOTOEventoCalendario(EventosCalendarioDTO dto){
        EventosCalendario e = new EventosCalendario();
        e.setId(dto.getId());
        e.setFecha(dto.getFecha());
        e.setTitulo(dto.getTitulo());
        e.setDescripcion(dto.getDescripcion());
        if (dto.getProyectoId() != null){
            Proyecto p = new Proyecto();
            p.setId(dto.getId());
            e.setProyecto(p);
        }
        return e;
    }
}
