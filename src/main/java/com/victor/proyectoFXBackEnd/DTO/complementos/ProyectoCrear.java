package com.victor.proyectoFXBackEnd.DTO.complementos;

import com.victor.proyectoFXBackEnd.DTO.ProyectoDTO;

public class ProyectoCrear {
    private ProyectoDTO proyectoDTO;
    private Integer id_usuario;

    public ProyectoCrear(ProyectoDTO proyectoDTO, Integer id_usuario) {
        this.proyectoDTO = proyectoDTO;
        this.id_usuario = id_usuario;
    }

    public ProyectoCrear() {
    }

    public ProyectoDTO getProyectoDTO() {
        return proyectoDTO;
    }

    public void setProyectoDTO(ProyectoDTO proyectoDTO) {
        this.proyectoDTO = proyectoDTO;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}
