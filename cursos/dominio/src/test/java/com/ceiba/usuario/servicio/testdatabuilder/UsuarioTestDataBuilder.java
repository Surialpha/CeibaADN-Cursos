package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;

public class UsuarioTestDataBuilder {

    private Long id;
    private Long cedula;
    private Long cedido;
    private String nombreUsuario;
    private LocalDate fecha_nacimiento;
    private LocalDate fecha_creacion;
    private float creditos;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "Sebastian";
        cedula = (long) 1214736979;
        fecha_nacimiento = LocalDate.parse("2002-01-01");
        fecha_creacion = LocalDate.now();
        creditos = (float) 200.0;
    }


    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
    
    public UsuarioTestDataBuilder conCedula(Long cedula) {
        this.cedula = cedula;
        return this;
    }
    
    public UsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }
    
    public UsuarioTestDataBuilder conFecha_nacimiento(LocalDate fecha_nacimiento) {
    	this.fecha_nacimiento = fecha_nacimiento;
    	return this;
    }
    
    public UsuarioTestDataBuilder conFecha_creacion(LocalDate fecha_creacion) {
    	this.fecha_creacion = fecha_creacion;
    	return this;
    }
    
    public UsuarioTestDataBuilder conCreditos(float creditos) {
    	this.creditos = creditos;
    	return this;
    }

    public UsuarioTestDataBuilder conCedido(Long cedido) {
        this.cedido = cedido;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,cedula,nombreUsuario,fecha_nacimiento,fecha_creacion,creditos,cedido);
    }
}
