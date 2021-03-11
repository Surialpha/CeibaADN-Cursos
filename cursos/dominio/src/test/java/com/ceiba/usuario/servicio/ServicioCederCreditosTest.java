package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCreditos;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCederCreditosTest {

    @Test
    public void validarCederCreditosTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).conCreditos(2L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.retornarCreditos(Mockito.anyLong())).thenReturn((float)0);
        ServicioCederCreditos servicioCederCreditos = new ServicioCederCreditos(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCederCreditos.ejecutar(usuario), ExcepcionCreditos.class,"El usuario no puede ceder más creditos de los que tiene");
    }

    @Test
    public void validarSumarCreditosTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).conCreditos(2L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.retornarCreditos(Mockito.anyLong())).thenReturn((float)400);
        ServicioCederCreditos servicioCederCreditos = new ServicioCederCreditos(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCederCreditos.ejecutar(usuario), ExcepcionCreditos.class,"El usuario no puede recibir esa cantidad de creditos ya que supera 400 creditos totales");
    }

}
