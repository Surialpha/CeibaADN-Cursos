package com.ceiba.inscripcion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;

public class ServicioActualizarInscripcion {

	private static final String VALIDAR = "El usuario ya existe en el sistema";

	private final RepositorioInscripcion repositorioInscripcion;


    public ServicioActualizarInscripcion(RepositorioInscripcion repositorioInscripcion) {
        this.repositorioInscripcion = repositorioInscripcion;
    }

    public void ejecutar(Inscripcion inscripcion) {
        //validar(inscripcion);
        this.repositorioInscripcion.actualizar(inscripcion);
    }

    private void validar(Inscripcion inscripcion) {
        if(true) {
            throw new ExcepcionDuplicidad(VALIDAR);
        }
    }
}
