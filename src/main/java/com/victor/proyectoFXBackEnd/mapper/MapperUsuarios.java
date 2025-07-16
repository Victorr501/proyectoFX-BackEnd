package com.victor.proyectoFXBackEnd.mapper;

import com.victor.proyectoFXBackEnd.DTO.UsuarioDTO;
import com.victor.proyectoFXBackEnd.config.password.Encriptar;
import com.victor.proyectoFXBackEnd.model.Usuario;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuarios {
    private  Encriptar encriptar = new Encriptar();
    public UsuarioDTO usuarioToUsuarioDTO(@NotNull Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setCorreos(usuario.getCorreo());
        usuarioDTO.setPasswordHaseada(usuario.getPasswordHaseada());
        usuarioDTO.setActivo(usuario.getActivo());
        return usuarioDTO;
    }

    public Usuario usuarioDTOToUsuarioRegistro(@NotNull UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreos());
        //Encripta la contrañea cuandos e crea
        usuario.setPasswordHaseada(encriptar.encodePassword(usuarioDTO.getPasswordHaseada()));
        usuario.setActivo(usuarioDTO.getActivo());
        return usuario;
    }

    public Usuario usuarioDTOToUsuario(@NotNull UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreos());
        usuario.setPasswordHaseada(usuarioDTO.getPasswordHaseada());
        usuario.setActivo(usuarioDTO.getActivo());
        return usuario;
    }
}
