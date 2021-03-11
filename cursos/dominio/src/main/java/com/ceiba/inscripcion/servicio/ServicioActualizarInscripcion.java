package com.ceiba.inscripcion.servicio;


import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;

public class ServicioActualizarInscripcion {




	private final RepositorioInscripcion repositorioInscripcion;


    public ServicioActualizarInscripcion(RepositorioInscripcion repositorioInscripcion) {
        this.repositorioInscripcion = repositorioInscripcion;
    }

    public void ejecutar(Inscripcion inscripcion) {
        this.repositorioInscripcion.actualizar(inscripcion);
    }



}
