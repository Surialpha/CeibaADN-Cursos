package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionMaximoIngresos;
import com.ceiba.dominio.excepcion.ExcepcionMayoriaEdad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class ServicioCrearUsuarioTest {

    
    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }

    @Test
    public void validarIngresosDiariosTest(){
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeDia(Mockito.any())).thenReturn((long )21);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionMaximoIngresos.class,"El sistema no permite el ingreso de mas de 20 usuarios diarios");
    }

    @Test
    public void validarUsuarioEdadTest(){
        // act - assert
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder().conFecha_nacimiento(LocalDate.now()).build(), ExcepcionMayoriaEdad.class,"El usuario debe ser mayor de edad");
    }
    
    
    @Test
    public void validarCostanteCreditosRegistroTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {

    	//Valida el maximo de creditos de un usuario, sea 200
    	Field field = ServicioCrearUsuario.class.getDeclaredField("CANTIDAD_DE_CREDITOS_AL_REGISTRARSE");
    	field.setAccessible(true);
    	int creditosRegistro = field.getInt(field);
    	assertEquals(200, creditosRegistro,0.0);
    	
    }
    

    @Test
    public void validarCostanteMaximoUsuariosPorDiaTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {

    	//Valida la constante de maximo de usuarios que pueden ser ingresados diariamente
    	Field field = ServicioCrearUsuario.class.getDeclaredField("MAXIMO_DE_USUARIOS_INGRESADOS_POR_DIA");
    	field.setAccessible(true);
    	int maximoRegistrosDiarios = field.getInt(field);
    	assertEquals(20, maximoRegistrosDiarios,0.0);
    	
    }

}
