package com.victor.proyectoFXBackEnd.service;

import com.victor.proyectoFXBackEnd.DTO.ProyectoDTO;
import com.victor.proyectoFXBackEnd.mapper.MapperProyectos;
import com.victor.proyectoFXBackEnd.model.Proyecto;
import com.victor.proyectoFXBackEnd.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {
    private ProyectoRepository pR;
    private MapperProyectos mP;

    public ProyectoService(ProyectoRepository pR, MapperProyectos mP){
        this.pR = pR;
        this.mP = mP;
    }

    public Boolean crearProyecto(ProyectoDTO pDTO, Integer id_usuario){
        if (pR.existsByNombreAndUsuario_Id(pDTO.getNombre(), id_usuario)){
            return false;
        }
        pDTO.setIdUsuario(id_usuario);
        Proyecto p = mP.proyectoDTOToProyecto(pDTO);
        try {
            pR.save(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
