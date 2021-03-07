package com.ceiba.inscripcion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;
import com.ceiba.inscripcion.servicio.testdatabuilder.InscripcionTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import java.time.LocalDate;

public class ServicioActualizarInscripcionTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Inscripcion inscripcion = new InscripcionTestDataBuilder().conFecha_inscripcion(LocalDate.parse("2021-07-03")).build();
        RepositorioInscripcion repositorioInscripcion = Mockito.mock(RepositorioInscripcion.class);
        ServicioActualizarInscripcion servicioActualizarInscripcion= new ServicioActualizarInscripcion(repositorioInscripcion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarInscripcion.ejecutar(inscripcion), ExcepcionInscripcion.class,"Solo es posible inscribirse a un curso entre semana");
    }

}
