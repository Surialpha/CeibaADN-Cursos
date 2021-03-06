package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";


    private Long id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaNacimiento;
    private Long cedula;

    public Usuario(Long id,Long cedula,String nombre,LocalDate fechaNacimiento) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaNacimiento = fechaNacimiento;
    }

}
