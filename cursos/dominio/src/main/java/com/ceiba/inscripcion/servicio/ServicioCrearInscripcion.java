package com.ceiba.inscripcion.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;


public class ServicioCrearInscripcion {

    private static final String VALIDAR = "El usuario ya existe en el sistema";

    private final RepositorioInscripcion repositorioInscripcion;

    public ServicioCrearInscripcion(RepositorioInscripcion repositorioInscripcion) {
    	
        this.repositorioInscripcion = repositorioInscripcion;
    }

    public Long ejecutar(Inscripcion inscripcion) {
    	inscripcion.setValor(aplicarDescuento(numeroInscritos(inscripcion.getCurso()),inscripcion.getValor()));
        return this.repositorioInscripcion.crear(inscripcion);
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
    
}
