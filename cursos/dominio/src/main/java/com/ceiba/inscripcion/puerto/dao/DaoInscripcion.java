package com.ceiba.inscripcion.puerto.dao;

import java.util.List;

import com.ceiba.inscripcion.modelo.dto.DtoInscripcion;


public interface DaoInscripcion {

	 /**
     * Permite listar inscripciones
     * @return las inscripciones
     */
    List<DtoInscripcion> listar();
}
