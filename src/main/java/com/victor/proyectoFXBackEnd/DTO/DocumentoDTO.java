package com.victor.proyectoFXBackEnd.DTO;

public class DocumentoDTO {
    private Integer id;

    private String nombre;
    private String contendio;

    private Integer proyectoId;

    public DocumentoDTO() {
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

    public String getContendio() {
        return contendio;
    }

    public void setContendio(String contendio) {
        this.contendio = contendio;
    }

    public Integer getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Integer proyectoId) {
        this.proyectoId = proyectoId;
    }
}
