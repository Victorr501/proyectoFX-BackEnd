package com.victor.proyectoFXBackEnd.repository;


import com.victor.proyectoFXBackEnd.model.Proyecto;
import com.victor.proyectoFXBackEnd.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    boolean existsByNombreAndUsuario_Id(String nombre, Integer id);
}
