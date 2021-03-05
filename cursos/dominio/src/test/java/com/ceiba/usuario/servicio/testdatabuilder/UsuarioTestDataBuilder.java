package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private Long cedula;
    private String nombreUsuario;
    private String clave;
    private LocalDateTime fecha;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        cedula = (long) 11214;
        clave = "1234";
        fecha = LocalDateTime.now();
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,cedula,nombreUsuario, clave,fecha);
    }
}
