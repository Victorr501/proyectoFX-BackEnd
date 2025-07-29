package com.victor.proyectoFXBackEnd.DTO.proyecto.tareaTitulo;

import java.time.LocalDate;

public class TareaDTO {
    private Integer id;

    private String contendio;

    private boolean completada;

    private LocalDate fechaLimite;

    private String prioridad;

    private Integer tareaTituloId;

    public TareaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContendio() {
        return contendio;
    }

    public void setContendio(String contendio) {
        this.contendio = contendio;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getTareaTituloId() {
        return tareaTituloId;
    }

    public void setTareaTituloId(Integer tareaTituloId) {
        this.tareaTituloId = tareaTituloId;
    }
}
