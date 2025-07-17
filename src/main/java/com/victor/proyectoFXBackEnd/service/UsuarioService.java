package com.victor.proyectoFXBackEnd.service;

import com.victor.proyectoFXBackEnd.DTO.UsuarioDTO;
import com.victor.proyectoFXBackEnd.config.password.Encriptar;
import com.victor.proyectoFXBackEnd.mapper.MapperUsuarios;
import com.victor.proyectoFXBackEnd.model.Usuario;
import com.victor.proyectoFXBackEnd.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final MapperUsuarios map;
    private final Encriptar encriptar;

    public UsuarioService(UsuarioRepository repo, MapperUsuarios map, Encriptar encriptar){
        this.repo = repo;
        this.map = map;
        this.encriptar = encriptar;
    }

    public Optional<UsuarioDTO> getUsuarioPorCorreo(String correo){
        //simplicia el codigo cambiando de usaurio a usaurioDTO por el metodo de mapperUsuario
        return repo.findByCorreo(correo)
                .map(map::usuarioToUsuarioDTO);
    }


    public Boolean registrar(UsuarioDTO usuarioDTO ){
        if (repo.existsByCorreo(usuarioDTO.getCorreo())){
            return false;
        }
        Usuario usuario = map.usuarioDTOToUsuarioRegistro(usuarioDTO);
        repo.save(usuario);
        return true;
    }

    public Boolean verificarContraseña(UsuarioDTO  usuarioDTO, String contraseña){
        Usuario usuario = map.usuarioDTOToUsuario(usuarioDTO);
        if (!repo.existsByCorreo(usuario.getCorreo())){
            return false;
        } else {
            return encriptar.matches(contraseña, usuario.getPasswordHaseada());
        }
    }
}
