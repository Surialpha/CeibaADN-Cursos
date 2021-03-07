package com.ceiba.dominio.excepcion;

public class ExcepcionInscripcion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionInscripcion(String mensaje) {
        super(mensaje);
    } 
}
