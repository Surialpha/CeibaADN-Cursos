package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCreditos;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCederCreditosTest {

    private static final int CONSTANTE_MAXIMOS_CREDITOS_PERMITIDOS = 400;
	private static final double VALOR_SUMA_CREDITOS = 102.0;

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
    
    @Test
    public void validarRetornarCreditosCedidoTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    	//Valida que la operacion de suma, no sea modificada
    	Usuario usuario = new UsuarioTestDataBuilder().conId(1L).conCreditos(2L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.retornarCreditos(Mockito.anyLong())).thenReturn((float)100);
    	Method method = ServicioCederCreditos.class.getDeclaredMethod("retornarCreditosCedido", Usuario.class);
    	method.setAccessible(true);
    	ServicioCederCreditos servicio = new ServicioCederCreditos(repositorioUsuario);
    	float suma =  (float) method.invoke(servicio, usuario );
    	assertEquals(VALOR_SUMA_CREDITOS, suma,0.0);
    	
    }
    
    @Test
    public void validarCostanteMaximoDeCreditosTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {

    	//Valida que la constante que valida el maximo de creditos disponibles, no sea modificada
    	Field field = ServicioCederCreditos.class.getDeclaredField("MAXIMO_CREDITOS_PERMITIDOS");
    	field.setAccessible(true);
    	int maximoCreditospermitidos = field.getInt(field);
    	assertEquals(CONSTANTE_MAXIMOS_CREDITOS_PERMITIDOS, maximoCreditospermitidos,0.0);
    	
    }
    

}
