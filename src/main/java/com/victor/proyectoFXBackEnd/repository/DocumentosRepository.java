package com.victor.proyectoFXBackEnd.repository;

import com.victor.proyectoFXBackEnd.model.proyecto.Documento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentosRepository extends JpaRepository<Documento, Integer> {
    Documento findbyProyectoId(Integer id);
}
