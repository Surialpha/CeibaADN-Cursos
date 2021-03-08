package com.ceiba.inscripcion.servicio.testdatabuilder;

import com.ceiba.inscripcion.comando.ComandoInscripcion;

import java.time.LocalDate;

public class ComandoInscripcionTestDataBuilder {

    private Long id;
    private Long usuario;
    private Long curso;
    private float valor;
    private LocalDate fecha_creacion;

    public ComandoInscripcionTestDataBuilder() {
       usuario=(long)1;
       curso=(long)1;
       valor=100;
       fecha_creacion=LocalDate.parse("2021-03-08");
    }

    public ComandoInscripcionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoInscripcionTestDataBuilder conUsuario(Long usuario) {
        this.usuario = usuario;
        return this;
    }

    public ComandoInscripcionTestDataBuilder conCurso(Long curso) {
        this.curso = curso;
        return this;
    }

    public ComandoInscripcionTestDataBuilder conValor(Long valor) {
        this.valor = valor;
        return this;
    }
    public ComandoInscripcionTestDataBuilder conFecha(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
        return this;
    }

    public ComandoInscripcion build() {
        return new ComandoInscripcion(id,usuario,curso,valor,fecha_creacion);
    }
}
