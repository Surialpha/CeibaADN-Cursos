package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioCederCreditos;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;

@Component
public class ManejadorCederCreditos implements ManejadorComando<ComandoUsuario> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCederCreditos servicioCederCreditos;

    public ManejadorCederCreditos(FabricaUsuario fabricaUsuario, ServicioCederCreditos servicioCederCreditos) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCederCreditos = servicioCederCreditos;
    }

    public void ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        this.servicioCederCreditos.ejecutar(usuario);
    }
}
 