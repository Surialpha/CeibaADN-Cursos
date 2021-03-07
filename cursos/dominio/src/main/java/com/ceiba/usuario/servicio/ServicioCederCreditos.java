package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionCreditos;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCederCreditos {

    private static final String EL_USUARIO_NO_TIENE_LA_CANTIDAD_DISPONIBLE_PARA_CEDER = "El usuario no puede ceder más creditos de los que tiene";
    private static final String EL_USUARIO_NO_PUEDE_RECIBIR_MAS_RECIBIR_CREDITOS = "El usuario no puede recibir esa cantidad de creditos ya que supera 400 creditos totales";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCederCreditos(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Usuario usuario) {
    	validarCreditosDisponibles(usuario);
    	validarCreditosSumados(usuario);
    	sumarCretidos(usuario);
    	usuario.setCreditos(restarCreditos(usuario));
        this.repositorioUsuario.cederCreditos(usuario);
    }

    public float restarCreditos(Usuario usuario) {
    	float creditosActualizados = retornarCreditosUsuario(usuario)-usuario.getCreditos();
    	
    	return creditosActualizados;
    }
    
    public void sumarCretidos(Usuario usuario) {
    	float creditosSumados = retornarCreditosCedido(usuario);
    	this.repositorioUsuario.sumarCreditos(usuario.getCedido(),creditosSumados);
    }
    
    
    public float retornarCreditosUsuario(Usuario usuario) {
    	float creditosD = repositorioUsuario.retornarCreditos(usuario.getId());
    	return creditosD;
    }
    
    public float retornarCreditosCedido(Usuario usuario) {
    	float creditosD = repositorioUsuario.retornarCreditos(usuario.getCedido());
    	float suma = creditosD+usuario.getCreditos();
    	return suma;
    }
    
    private void validarCreditosDisponibles(Usuario usuario) {
    	float disponible = retornarCreditosUsuario(usuario);
        if(disponible<usuario.getCreditos()) {
            throw new ExcepcionCreditos(EL_USUARIO_NO_TIENE_LA_CANTIDAD_DISPONIBLE_PARA_CEDER);
        }
    }
    
    private void validarCreditosSumados(Usuario usuario) {
    	float sumados = retornarCreditosCedido(usuario);
        if(sumados>400) {
            throw new ExcepcionCreditos(EL_USUARIO_NO_PUEDE_RECIBIR_MAS_RECIBIR_CREDITOS);
        }
    }
}
