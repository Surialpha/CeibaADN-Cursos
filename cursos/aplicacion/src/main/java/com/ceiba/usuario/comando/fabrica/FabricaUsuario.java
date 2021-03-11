package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        return new Usuario(
        		comandoUsuario.getId(),
        		comandoUsuario.getCedula(),
        		comandoUsuario.getNombre(),
        		comandoUsuario.getFechaNacimiento(), 
        		LocalDate.now(), 
        		comandoUsuario.getCreditos(),
        		comandoUsuario.getCedido()
        );
    }

}
