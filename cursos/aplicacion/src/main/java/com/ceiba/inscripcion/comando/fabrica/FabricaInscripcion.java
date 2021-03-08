package com.ceiba.inscripcion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.inscripcion.comando.ComandoInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;

import java.time.LocalDate;

@Component
public class FabricaInscripcion {

    public Inscripcion crear(ComandoInscripcion comandoInscripcion) {
        return new Inscripcion(
        		comandoInscripcion.getId(),
        		comandoInscripcion.getUsuario(),
        		comandoInscripcion.getCurso(),
        		comandoInscripcion.getValor(),
				LocalDate.now()
        );
    }

}
