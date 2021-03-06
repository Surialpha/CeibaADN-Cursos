package com.ceiba.inscripcion.comando.manejador;

import com.ceiba.inscripcion.servicio.ServicioEliminarInscripcion;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarInscripcion implements ManejadorComando<Long> {

    private final ServicioEliminarInscripcion servicioEliminarinscripcion;

    public ManejadorEliminarInscripcion(ServicioEliminarInscripcion servicioEliminarInscripcion) {
        this.servicioEliminarinscripcion = servicioEliminarInscripcion;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarinscripcion.ejecutar(idUsuario);
    }
}
