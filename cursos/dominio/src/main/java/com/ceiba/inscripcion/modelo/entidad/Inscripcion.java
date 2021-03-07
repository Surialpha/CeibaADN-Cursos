package com.ceiba.inscripcion.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inscripcion {

	private static final String SE_DEBE_INGRESAR_EL_USUARIO = "Se debe ingresar el usuario";
	private static final String SE_DEBE_INGRESAR_EL_CURSO = "Se debe ingresar el curso";
	private static final String SE_DEBE_INGRESAR_EL_VALOR = "Se debe ingresar el curso";
	
	private Long id;
	private Long usuario;
	private Long curso;
	private float valor;
	private LocalDate fechaInscripcion;
	
	public Inscripcion(Long id,Long usuario,Long curso, float valor,LocalDate fechaInscripcion) {
        validarObligatorio(usuario, SE_DEBE_INGRESAR_EL_USUARIO);
        validarObligatorio(curso, SE_DEBE_INGRESAR_EL_CURSO);
        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR);
        
        this.id=id;
        this.usuario=usuario;
        this.curso=curso;
        this.valor=valor;
        this.fechaInscripcion=LocalDate.parse("2021-03-08");
    }
}
