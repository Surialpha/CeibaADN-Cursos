package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long id;
    private Long cedula;
    private String nombre;
    private float creditos;
    private LocalDate fechaCreacion;
    private LocalDate fechaNacimiento;
    
}
