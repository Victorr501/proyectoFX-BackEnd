package com.victor.proyectoFXBackEnd.Service;

import com.victor.proyectoFXBackEnd.DTO.UsuarioDTO;
import com.victor.proyectoFXBackEnd.Mapper.MapperUsuarios;
import com.victor.proyectoFXBackEnd.Model.Usuario;
import com.victor.proyectoFXBackEnd.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo){
        this.repo = repo;
    }

    public Optional<UsuarioDTO> getUsuarioPorCorreo(String correo){
        //simplicia el codigo cambiando de usaurio a usaurioDTO por el metodo de mapperUsuario
        return repo.buscarPorCorreo(correo)
                .map(MapperUsuarios::usuarioToUsuarioDTO);

    }
}
