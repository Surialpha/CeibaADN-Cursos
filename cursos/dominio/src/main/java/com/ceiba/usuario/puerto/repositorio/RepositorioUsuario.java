package com.ceiba.usuario.puerto.repositorio;

import java.time.LocalDate;

import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {
    /**
     * Permite crear un usuario
     * @param usuario
     * @return el id generado
     */
    Long crear(Usuario usuario);

    /**
     * Permite actualizar un usuario
     * @param usuario
     */
    void actualizar(Usuario usuario);
    
    /**
     * Permite actualizar un usuario que cede creditos
     * @param usuario
     */
    void cederCreditos(Usuario usuario);
    
    /**
     * Permite actualizar un usuario que le cedieron creditos
     * @param usuario
     */
    void sumarCreditos(Long id, float creditos);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(Long cedula);
    
    Long existeDia(LocalDate fecha);
    
    /**
     * Permite retornar el numero de cretidos que tiene un usuario
     * @param nombre
     * @return creditos
     */
    float retornarCreditos(Long id);
    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,Long cedula);

}
