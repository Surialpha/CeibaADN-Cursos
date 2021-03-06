package com.ceiba.inscripcion.comando.manejador;

import com.ceiba.inscripcion.comando.ComandoInscripcion;
import com.ceiba.inscripcion.comando.fabrica.FabricaInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.servicio.ServicioActualizarInscripcion;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorActualizarInscripcion implements ManejadorComando<ComandoInscripcion> {

    private final FabricaInscripcion fabricainsInscripcion;
    private final ServicioActualizarInscripcion servicioActualizarUsuario;

    public ManejadorActualizarInscripcion(FabricaInscripcion fabricainsInscripcion, ServicioActualizarInscripcion servicioActualizarinscripcion) {
        this.fabricainsInscripcion = fabricainsInscripcion;
        this.servicioActualizarUsuario = servicioActualizarinscripcion;
    }

    public void ejecutar(ComandoInscripcion comandoInscripcion) {
        Inscripcion inscripcion = this.fabricainsInscripcion.crear(comandoInscripcion);
        this.servicioActualizarUsuario.ejecutar(inscripcion);
    }
}
