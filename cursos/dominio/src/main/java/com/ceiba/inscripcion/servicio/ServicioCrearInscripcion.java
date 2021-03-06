package com.ceiba.inscripcion.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;


public class ServicioCrearInscripcion {

    private static final String VALIDAR = "El usuario ya existe en el sistema";

    private final RepositorioInscripcion repositorioInscripcion;

    public ServicioCrearInscripcion(RepositorioInscripcion repositorioInscripcion) {
    	
        this.repositorioInscripcion = repositorioInscripcion;
    }

    public Long ejecutar(Inscripcion inscripcion) {
    	//validar(inscripcion);
        return this.repositorioInscripcion.crear(inscripcion);
    }
    

    private void validar(Inscripcion inscripcion) {
        if(true) {
            throw new ExcepcionDuplicidad(VALIDAR);
        }
    }
}
