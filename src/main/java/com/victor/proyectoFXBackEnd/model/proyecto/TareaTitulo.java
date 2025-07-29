package com.victor.proyectoFXBackEnd.model.proyecto;

import com.victor.proyectoFXBackEnd.model.Proyecto;
import com.victor.proyectoFXBackEnd.model.proyecto.tareaTitulo.Tarea;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TareaTitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Lob
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "documento_id")
    private Proyecto proyecto;

    @OneToMany(mappedBy = "tareaTitulo",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas = new ArrayList<>();

    public TareaTitulo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
