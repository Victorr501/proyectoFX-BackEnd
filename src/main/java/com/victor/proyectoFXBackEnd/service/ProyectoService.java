package com.victor.proyectoFXBackEnd.service;

import com.victor.proyectoFXBackEnd.DTO.ProyectoDTO;
import com.victor.proyectoFXBackEnd.mapper.MapperProyectos;
import com.victor.proyectoFXBackEnd.model.Proyecto;
import com.victor.proyectoFXBackEnd.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ProyectoDTO> obtenerProyectosPorUsuario(Integer id_usuario){
        List<Proyecto> proyectos = pR.findByUsuarioId(id_usuario);
        return proyectos.stream()
                .map(mP::proyectoToProyectoDTO)
                .toList();
    }

    public ProyectoDTO obtenerProyectosPorId(Integer id_proyectos){
        Proyecto proyecto =  pR.findById(id_proyectos).orElseThrow(() -> new RuntimeException("Proyecto no encontrado con id: " + id_proyectos));
        return mP.proyectoToProyectoDTO(proyecto);
    }
}
