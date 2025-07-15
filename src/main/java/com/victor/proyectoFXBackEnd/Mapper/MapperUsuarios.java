package com.victor.proyectoFXBackEnd.Mapper;

import com.victor.proyectoFXBackEnd.DTO.UsuarioDTO;
import com.victor.proyectoFXBackEnd.Model.Usuario;
import org.jetbrains.annotations.NotNull;

public class MapperUsuarios {
    public static UsuarioDTO usuarioToUsuarioDTO(@NotNull Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setCorreos(usuario.getCorreo());
        usuarioDTO.setPasswordHaseada(usuario.getPasswordHaseada());
        usuarioDTO.setActivo(usuario.getActivo());
        return usuarioDTO;
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
