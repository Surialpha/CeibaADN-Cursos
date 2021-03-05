package com.ceiba.dominio.excepcion;

public class ExcepcionMaximoIngresos extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionMaximoIngresos(String message) {
        super(message);
    }
}
