package com.ceiba.inscripcion.puerto.dao;

import java.util.List;

import com.ceiba.inscripcion.modelo.dto.DtoInscripcion;


public interface DaoInscripcion {

	 /**
     * Permite listar inscripciones
     * @return las inscripciones
     */
    List<DtoInscripcion> listar();
    
    /**
     * Permite listar inscripciones por id
     * @return las inscripciones
     */
    List<DtoInscripcion> listarBy(Long id);
    /**
     * Permite listar inscripciones por usuario
     * @return la inscripcion
     */
    List<DtoInscripcion> listarByUser(Long user);
    
}
