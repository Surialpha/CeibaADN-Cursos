package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionMayoriaEdad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.LocalDate;
import java.time.Period;

public class ServicioActualizarUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    private static final String EL_USUARIO_ES_MENOR_DE_EDAD = "El usuario debe ser mayor de edad";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario);
        validarMayoriaEdad(usuario);
        this.repositorioUsuario.actualizar(usuario);
    }

    public void validarMayoriaEdad(Usuario usuario) {
        LocalDate Ingresosdia = usuario.getFechaNacimiento();
        Period period =Period.between(Ingresosdia, LocalDate.now());
        if(period.getYears() < 18) {
            throw new ExcepcionMayoriaEdad(EL_USUARIO_ES_MENOR_DE_EDAD);
        }
    }

    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existeExcluyendoId(usuario.getId(),usuario.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
