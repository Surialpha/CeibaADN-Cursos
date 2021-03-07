package com.ceiba.inscripcion.puerto.repositorio;


import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.usuario.modelo.entidad.Usuario;


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
    
    /**
     * Permite buscar el numero de inscritos diarios en un curso
     * @param id
     */
    int numeroInscritos(Long curso);
    
    void cederCreditos(Usuario usuario);
    
    float retornarCreditos(Long id);

}
