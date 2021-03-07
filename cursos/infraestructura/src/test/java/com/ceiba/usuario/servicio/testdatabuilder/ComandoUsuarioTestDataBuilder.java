package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private Long cedula;
    private String nombre;
    private LocalDateTime fecha;
    private LocalDate fecha_nacimiento;
    private Long cedido;
    private float creditos;

    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        fecha = LocalDateTime.now();
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,cedula,nombre,fecha,fecha_nacimiento,creditos,cedido);
    }
}
