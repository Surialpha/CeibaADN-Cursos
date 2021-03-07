package com.ceiba.inscripcion.servicio;

import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.Set;

import com.ceiba.dominio.excepcion.ExcepcionInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ServicioActualizarInscripcion {

	 private static final String SOLO_SE_PUEDEN_HACER_INSCRIPCIONES_ENTRE_SEMANA = "Solo es posible inscribirse a un curso entre semana";
	 private static final String NO_TIENES_CREDITOS_SUFICIENTES_PARA_INSCRIBIRTE = "No es posible inscribirte a este curso, no tienes los creditos suficientes";


	private final RepositorioInscripcion repositorioInscripcion;


    public ServicioActualizarInscripcion(RepositorioInscripcion repositorioInscripcion) {
        this.repositorioInscripcion = repositorioInscripcion;
    }

    public void ejecutar(Inscripcion inscripcion) {
    	//validarDiaSemana(inscripcion);
        this.repositorioInscripcion.actualizar(inscripcion);
    }

    public float retornarCreditosUsuario(Long id) {
    	float creditosD = repositorioInscripcion.retornarCreditos(id);
    	return creditosD;
    }
    
    public void restarCreditos(Inscripcion inscripcion) {
    	float creditosActualizados = retornarCreditosUsuario(inscripcion.getUsuario())-inscripcion.getValor();
    	if(creditosActualizados<0) {
    	 throw new ExcepcionInscripcion(NO_TIENES_CREDITOS_SUFICIENTES_PARA_INSCRIBIRTE);
    	}
    	Usuario usuario = new Usuario(inscripcion.getUsuario(), creditosActualizados);
    	this.repositorioInscripcion.cederCreditos(usuario);
    }

    private int numeroInscritos(Long curso) {
    	int numeroInscritos = this.repositorioInscripcion.numeroInscritos(curso);
    	System.out.print(numeroInscritos);
        if(numeroInscritos>=4) {
        	return numeroInscritos-4;
        }
        else {
        	return 0;
        }
    }
    
    private float aplicarDescuento(int consDes , float valor) {
    	
    	return (float) ((float) valor+(valor*(0.01*consDes)));
      
    }
    
    public void validarDiaSemana(Inscripcion inscripcion) {
    	
    	DayOfWeek dow = inscripcion.getFechaInscripcion().getDayOfWeek();
    	Set<DayOfWeek> weekend = EnumSet.of( DayOfWeek.SATURDAY , DayOfWeek.SUNDAY );
    	
    	if(weekend.contains(dow)) {
    		throw new ExcepcionInscripcion(SOLO_SE_PUEDEN_HACER_INSCRIPCIONES_ENTRE_SEMANA);
    	}
    	
    }
}
