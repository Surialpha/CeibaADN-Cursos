package com.ceiba.dominio.excepcion;

public class ExcepcionCreditos extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCreditos(String mensaje) {
        super(mensaje);
    }
}
