package com.ceiba.inscripcion.servicio.testdatabuilder;

import com.ceiba.inscripcion.modelo.entidad.Inscripcion;

import java.time.LocalDate;

public class InscripcionTestDataBuilder {

    private Long id;
    private Long usuario;
    private Long curso;
    private float valor;
    private LocalDate fecha_inscripcion;

    public InscripcionTestDataBuilder() {
       usuario=(long)1;
       curso=(long)1;
       valor=100;
       fecha_inscripcion=LocalDate.parse("2021-02-02");
    }


    public InscripcionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public InscripcionTestDataBuilder conUsuario(Long usuario) {
        this.usuario = usuario;
        return this;
    }

    public InscripcionTestDataBuilder conCurso(Long curso) {
        this.curso = curso;
        return this;
    }

    public InscripcionTestDataBuilder conValor(float valor) {
        this.valor = valor;
        return this;
    }
    public InscripcionTestDataBuilder conFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
        return this;
    }

    public Inscripcion build() {
        return new Inscripcion(id,usuario,curso,valor,fecha_inscripcion);
    }
}
