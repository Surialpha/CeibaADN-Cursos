package com.ceiba.inscripcion.comando;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoInscripcion{
 
	private Long id;
	private Long usuario;
	private Long curso;
	private float valor;
	private LocalDate fechaInscripcion;
}
