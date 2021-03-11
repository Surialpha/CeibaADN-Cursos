package com.ceiba.inscripcion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;
import com.ceiba.inscripcion.servicio.testdatabuilder.InscripcionTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class ServicioCrearInscripcionTest {

    public static final float CONSTANTE_VALOR = (float)103.0;

    @Test
    public void validarCreditosDisponiblesTest() {
        // arrange
        Inscripcion inscripcion = new InscripcionTestDataBuilder().conValor(100).build();
        RepositorioInscripcion repositorioInscripcion = Mockito.mock(RepositorioInscripcion.class);
        Mockito.when(repositorioInscripcion.retornarCreditos(Mockito.anyLong())).thenReturn((float)0);
        ServicioCrearInscripcion servicioCrearInscripcion = new ServicioCrearInscripcion(repositorioInscripcion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearInscripcion.ejecutar(inscripcion), ExcepcionInscripcion.class,"No es posible inscribirte a este curso, no tienes los creditos suficientes");
    }

    @Test
    public void validarFechainscripcionTest(){
        // act - assert
        BasePrueba.assertThrows(() ->  new InscripcionTestDataBuilder().conFecha_inscripcion(LocalDate.parse("2021-03-07")).build(), ExcepcionInscripcion.class,"Solo es posible inscribirse a un curso entre semana");
    }

    @Test
    public void validarValorPorcentualTest() {
        // arrange

        Inscripcion inscripcion = new InscripcionTestDataBuilder().conValor(100).build();
        RepositorioInscripcion repositorioInscripcion = Mockito.mock(RepositorioInscripcion.class);
        Mockito.when(repositorioInscripcion.retornarCreditos(Mockito.anyLong())).thenReturn((float)200);
        Mockito.when(repositorioInscripcion.numeroInscritos(Mockito.anyLong())).thenReturn(8);
        ServicioCrearInscripcion servicioCrearInscripcion = new ServicioCrearInscripcion(repositorioInscripcion);
        servicioCrearInscripcion.ejecutar(inscripcion);
        // act - assert
        assertEquals(CONSTANTE_VALOR,inscripcion.getValor(), 0.0);
    }

}
