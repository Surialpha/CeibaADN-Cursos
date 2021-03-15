package com.ceiba.inscripcion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionInscripcion;
import com.ceiba.inscripcion.servicio.testdatabuilder.InscripcionTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;


public class ServicioActualizarInscripcionTest {


    @Test
    public void validarFechainscripcionTest(){
        // act - assert
        BasePrueba.assertThrows(() ->  new InscripcionTestDataBuilder().conFecha_inscripcion(LocalDate.parse("2021-03-07")).build(), ExcepcionInscripcion.class,"Solo es posible inscribirse a un curso entre semana");
    }
   

}
