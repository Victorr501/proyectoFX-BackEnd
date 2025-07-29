package com.victor.proyectoFXBackEnd.model;

import com.victor.proyectoFXBackEnd.model.proyecto.Documento;
import com.victor.proyectoFXBackEnd.model.proyecto.EventosCalendario;
import com.victor.proyectoFXBackEnd.model.proyecto.TareaTitulo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proyecto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(length = 1000)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false )
    private LocalDate fechaCreacion;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    //realacion con los apartados
    @OneToMany(mappedBy = "proyecto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos = new ArrayList<>();

    @OneToMany(mappedBy = "proyecto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventosCalendario> eventosCalendario = new ArrayList<>();

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TareaTitulo> tareaTitulos = new ArrayList<>();

    @PrePersist
    protected void onCreate(){
        this.fechaCreacion = LocalDate.now();
    }

    public Proyecto() {
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<EventosCalendario> getEventosCalendario() {
        return eventosCalendario;
    }

    public void setEventosCalendario(List<EventosCalendario> eventosCalendario) {
        this.eventosCalendario = eventosCalendario;
    }

    public List<TareaTitulo> getTareaTitulos() {
        return tareaTitulos;
    }

    public void setTareaTitulos(List<TareaTitulo> tareaTitulos) {
        this.tareaTitulos = tareaTitulos;
    }
}
