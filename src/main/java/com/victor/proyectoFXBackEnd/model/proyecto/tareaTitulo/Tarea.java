package com.victor.proyectoFXBackEnd.model.proyecto.tareaTitulo;

import com.victor.proyectoFXBackEnd.model.proyecto.TareaTitulo;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String contenido;

    private boolean completada;

    private LocalDate fechaLimite;

    private String priodidad;

    @ManyToOne
    @JoinColumn(name = "tarea_titulo_id")
    private TareaTitulo tareaTitulo;

    public Tarea(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public String getPriodidad() {
        return priodidad;
    }

    public void setPriodidad(String priodidad) {
        this.priodidad = priodidad;
    }

    public TareaTitulo getTareaTitulo() {
        return tareaTitulo;
    }

    public void setTareaTitulo(TareaTitulo tareaTitulo) {
        this.tareaTitulo = tareaTitulo;
    }
}
