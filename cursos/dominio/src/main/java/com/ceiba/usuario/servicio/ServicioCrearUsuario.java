package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionMaximoIngresos;


public class ServicioCrearUsuario {

    private static final int CANTIDAD_DE_CREDITOS_AL_REGISTRARSE = 200;
	private static final int MAXIMO_DE_USUARIOS_INGRESADOS_POR_DIA = 20;
	private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    private static final String EL_LIMITE_DE_USUARIOS_YA_SE_CUMPLIO = "El sistema no permite el ingreso de mas de 20 usuarios diarios";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario);
        validarIngresosDiarios(usuario);
        usuario.setCreditos(CANTIDAD_DE_CREDITOS_AL_REGISTRARSE);
        return this.repositorioUsuario.crear(usuario);
    }
    
    private void validarIngresosDiarios(Usuario usuario) { 
    	 Long Ingresosdia = this.repositorioUsuario.existeDia(usuario.getFechaCreacion());
         if(Ingresosdia>=MAXIMO_DE_USUARIOS_INGRESADOS_POR_DIA) {
         	throw new ExcepcionMaximoIngresos(EL_LIMITE_DE_USUARIOS_YA_SE_CUMPLIO);	
         }
    }
  
    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existe(usuario.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
