package com.ceiba.inscripcion.servicio;


import com.ceiba.dominio.excepcion.ExcepcionInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;
import com.ceiba.usuario.modelo.entidad.Usuario;


public class ServicioCrearInscripcion {

    private static final int CERO = 0;
	private static final int NUMERO_MAXIMO_PERMITIDO_INSCRITOS = 5;
    private static final String NO_TIENES_CREDITOS_SUFICIENTES_PARA_INSCRIBIRTE = "No es posible inscribirte a este curso, no tienes los creditos suficientes";
    public static final double CONSTANTE_PORCENTAJE_POR_USUARIO = 0.01;

    private final RepositorioInscripcion repositorioInscripcion;

    public ServicioCrearInscripcion(RepositorioInscripcion repositorioInscripcion) {
        this.repositorioInscripcion = repositorioInscripcion;
    }

    public Long ejecutar(Inscripcion inscripcion) {
    	restarCreditos(inscripcion);
    	inscripcion.setValor(aplicarDescuento(numeroInscritos(inscripcion.getCurso()),inscripcion.getValor()));
        return this.repositorioInscripcion.crear(inscripcion);
    }
    
    private float retornarCreditosUsuario(Long id) {
    	float creditosD = repositorioInscripcion.retornarCreditos(id);
    	return creditosD;
    }
    
    private void restarCreditos(Inscripcion inscripcion) {
    	float creditosActualizados = retornarCreditosUsuario(inscripcion.getUsuario())-inscripcion.getValor();
    	if(creditosActualizados<CERO) {
    	 throw new ExcepcionInscripcion(NO_TIENES_CREDITOS_SUFICIENTES_PARA_INSCRIBIRTE);
    	}
    	//CAMBIAR USUARIO A VARIABLES
    	Usuario usuario = new Usuario(inscripcion.getUsuario(), creditosActualizados);
    	this.repositorioInscripcion.cederCreditos(usuario);
    }

    private int numeroInscritos(Long curso) {
    	int numeroInscritos = this.repositorioInscripcion.numeroInscritos(curso);
    	System.out.print(numeroInscritos);
        if(numeroInscritos>=NUMERO_MAXIMO_PERMITIDO_INSCRITOS) {
        	return numeroInscritos-NUMERO_MAXIMO_PERMITIDO_INSCRITOS;
        }
        else {
        	return CERO;
        }
    }
    
    private float aplicarDescuento(int consDes , float valor) {
    	
    	return (float) (valor+(valor*(CONSTANTE_PORCENTAJE_POR_USUARIO *consDes)));
      
    }
    
}
