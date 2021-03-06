package com.ceiba.inscripcion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inscripcion.comando.ComandoInscripcion;
import com.ceiba.inscripcion.comando.fabrica.FabricaInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.servicio.ServicioCrearInscripcion;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearInscripcion implements ManejadorComandoRespuesta<ComandoInscripcion, ComandoRespuesta<Long>> {

    private final FabricaInscripcion fabricaInscripcion;
    private final ServicioCrearInscripcion servicioCrearUsuario;

    public ManejadorCrearInscripcion(FabricaInscripcion fabricaInscripcion, ServicioCrearInscripcion servicioCrearInscripcion) {
        this.fabricaInscripcion = fabricaInscripcion;
        this.servicioCrearUsuario = servicioCrearInscripcion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoInscripcion comandoInscripcion) {
        Inscripcion inscripcion = this.fabricaInscripcion.crear(comandoInscripcion);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(inscripcion));
    }

	
}
