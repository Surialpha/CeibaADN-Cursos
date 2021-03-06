package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;

public class UsuarioTestDataBuilder {

    private Long id;
    private Long cedula;
    private String nombreUsuario;
    private LocalDate fecha_nacimiento;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        cedula = (long) 11214;
    }


    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,cedula,nombreUsuario,fecha_nacimiento);
    }
}
