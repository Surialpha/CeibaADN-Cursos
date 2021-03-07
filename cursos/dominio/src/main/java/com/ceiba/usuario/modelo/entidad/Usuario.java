package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";


    private Long id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaNacimiento;
    private Long cedula;
    private float creditos;
    private Long cedido;

    public Usuario(Long id,Long cedula,String nombre,LocalDate fechaNacimiento,LocalDateTime fechaCreacion,float creditos,Long cedido) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaNacimiento = fechaNacimiento;
        this.creditos = creditos;
        this.cedido = cedido;
    }
    
    public Usuario(Long id,float creditos) {
    	this.id = id;
    	this.creditos = creditos;
    }

}
