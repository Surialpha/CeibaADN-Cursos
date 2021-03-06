package com.ceiba.inscripcion.puerto.repositorio;


import com.ceiba.inscripcion.modelo.entidad.Inscripcion;


public interface RepositorioInscripcion {
	 /**
     * Permite crear una inscripcion
     * @param inscripcion
     * @return el id generado
     */
    Long crear(Inscripcion inscripcion);

    /**
     * Permite actualizar una inscripcion
     * @param inscripcion
     */
    void actualizar(Inscripcion inscripcion);

    /**
     * Permite eliminar una inscripcion
     * @param id
     */
    void eliminar(Long id);

}
