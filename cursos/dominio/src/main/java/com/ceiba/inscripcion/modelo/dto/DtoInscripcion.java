package com.ceiba.inscripcion.modelo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoInscripcion {
	
	private Long id;
	private Long usuario;
	private Long curso;
	private float valor;
	private LocalDate fechaInscripcion;

}
