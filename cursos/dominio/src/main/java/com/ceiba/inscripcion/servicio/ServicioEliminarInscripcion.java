package com.ceiba.inscripcion.servicio;

import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;

public class ServicioEliminarInscripcion{

	private final RepositorioInscripcion repositorioInscripcion;

    public ServicioEliminarInscripcion(RepositorioInscripcion repositorioInscripcion) {
        this.repositorioInscripcion = repositorioInscripcion;
    }

    public void ejecutar(Long id) {
        this.repositorioInscripcion.eliminar(id);
    }
}
