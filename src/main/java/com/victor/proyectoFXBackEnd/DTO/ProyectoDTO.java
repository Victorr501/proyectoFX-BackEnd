package com.victor.proyectoFXBackEnd.DTO;

import com.victor.proyectoFXBackEnd.model.EventosCalendario;
import com.victor.proyectoFXBackEnd.model.TareaTitulo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String fechaCreacion;
    private Integer idUsuario;

    private List<DocumentoDTO> documentoDTOList = new ArrayList<>();

    private List<EventosCalendarioDTO> eventosCalendarioDTOS = new ArrayList<>();

    private List<TareaTituloDTO> tareaTituloDTOS = new ArrayList<>();

    public ProyectoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<DocumentoDTO> getDocumentoDTOList() {
        return documentoDTOList;
    }

    public void setDocumentoDTOList(List<DocumentoDTO> documentoDTOList) {
        this.documentoDTOList = documentoDTOList;
    }

    public List<EventosCalendarioDTO> getEventosCalendarioDTOS() {
        return eventosCalendarioDTOS;
    }

    public void setEventosCalendarioDTOS(List<EventosCalendarioDTO> eventosCalendarioDTOS) {
        this.eventosCalendarioDTOS = eventosCalendarioDTOS;
    }

    public List<TareaTituloDTO> getTareaTituloDTOS() {
        return tareaTituloDTOS;
    }

    public void setTareaTituloDTOS(List<TareaTituloDTO> tareaTituloDTOS) {
        this.tareaTituloDTOS = tareaTituloDTOS;
    }
}
