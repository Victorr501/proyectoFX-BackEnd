package com.victor.proyectoFXBackEnd.mapper;


import com.victor.proyectoFXBackEnd.DTO.ProyectoDTO;
import com.victor.proyectoFXBackEnd.model.Proyecto;
import com.victor.proyectoFXBackEnd.model.Usuario;

public class MapperProyectos {
    public ProyectoDTO proyectoToProyectoDTO(Proyecto p){
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setNombre(p.getNombre());
        proyectoDTO.setDescripcion(p.getDescripcion());
        if (p.getUsuario() != null){
            proyectoDTO.setId(p.getUsuario().getId());
        }
        proyectoDTO.setFechaCreacion(p.getFechaCreacion());
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
        proyecto.setFechaCreacion(p.getFechaCreacion());
        return proyecto;
    }
}
