package com.ceiba.usuario.comando;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{
 
    private Long id;
    private Long cedula;
    private String nombre;
    private LocalDateTime fecha;
    private LocalDate fechaNacimiento;
}
