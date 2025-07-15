package com.victor.proyectoFXBackEnd.DTO;


public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String correos;
    private String passwordHaseada;
    private Boolean activo;

    public UsuarioDTO() {
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

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public String getPasswordHaseada() {
        return passwordHaseada;
    }

    public void setPasswordHaseada(String passwordHaseada) {
        this.passwordHaseada = passwordHaseada;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
