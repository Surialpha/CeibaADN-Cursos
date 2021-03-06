package com.ceiba.dominio.excepcion;

public class ExcepcionMayoriaEdad extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	    public ExcepcionMayoriaEdad(String message) {
	        super(message);
	    }
}
