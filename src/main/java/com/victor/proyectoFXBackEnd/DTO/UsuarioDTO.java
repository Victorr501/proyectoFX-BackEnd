package com.victor.proyectoFXBackEnd.DTO;


public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
