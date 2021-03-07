package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private Long cedula;
    private String nombre;
    private LocalDate fecha;
    private LocalDate fecha_nacimiento;
    private Long cedido;
    private float creditos;

    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        fecha = LocalDate.now();
        fecha_nacimiento = LocalDate.parse("2000-09-16");
        cedula=(long)12345;
        creditos=200;

    }

    public ComandoUsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombre = nombreUsuario;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conFecha_creacion(LocalDate fecha_creacion) {
        this.fecha = fecha_creacion;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCreditos(float creditos) {
        this.creditos = creditos;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCedido(Long cedido) {
        this.cedido = cedido;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,cedula,nombre,fecha,fecha_nacimiento,creditos,cedido);
    }
}
