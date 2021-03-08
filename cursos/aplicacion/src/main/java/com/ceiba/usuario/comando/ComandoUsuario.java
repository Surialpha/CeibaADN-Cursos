package com.ceiba.usuario.comando;

import java.time.LocalDate;

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
    private LocalDate fecha;
    private LocalDate fechaNacimiento;
    private float creditos;
    private Long cedido;
    
}
