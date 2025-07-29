package com.victor.proyectoFXBackEnd.mapper;


import com.victor.proyectoFXBackEnd.DTO.ProyectoDTO;
import com.victor.proyectoFXBackEnd.mapper.proyecto.MapperDocumentos;
import com.victor.proyectoFXBackEnd.model.Proyecto;
import com.victor.proyectoFXBackEnd.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MapperProyectos {

    private MapperDocumentos mD = new MapperDocumentos();
    public ProyectoDTO proyectoToProyectoDTO(Proyecto p){
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setId(p.getId());
        proyectoDTO.setNombre(p.getNombre());
        proyectoDTO.setDescripcion(p.getDescripcion());
        if (p.getUsuario() != null){
            proyectoDTO.setIdUsuario(p.getUsuario().getId());
        }
        proyectoDTO.setFechaCreacion(p.getFechaCreacion().toString());
        return proyectoDTO;
    }

    public Proyecto proyectoDTOToProyecto(ProyectoDTO p){
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(p.getNombre());
        proyecto.setDescripcion(p.getDescripcion());
        if (p.getIdUsuario() != null){
            Usuario u = new Usuario();
            u.setId(p.getIdUsuario());
            proyecto.setUsuario(u);
        }
        proyecto.setId(p.getId());
        String fechaString = p.getFechaCreacion();
        if (fechaString != null && !fechaString.isEmpty()) {
            proyecto.setFechaCreacion(LocalDate.parse(fechaString));
        } else {
            proyecto.setFechaCreacion(null); // o la fecha que quieras por defecto
        }
        return proyecto;
    }
}
