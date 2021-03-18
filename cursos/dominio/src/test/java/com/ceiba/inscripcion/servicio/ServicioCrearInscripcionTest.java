package com.ceiba.inscripcion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionInscripcion;
import com.ceiba.inscripcion.modelo.entidad.Inscripcion;
import com.ceiba.inscripcion.puerto.repositorio.RepositorioInscripcion;
import com.ceiba.inscripcion.servicio.testdatabuilder.InscripcionTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class ServicioCrearInscripcionTest {

    private static final int CONSTANTE_DE_USUARIOS_MAXIMO_INSCRITOS_SIN_APLICAR_AUMENTOS = 5;
	private static final double PORCENTAJE_DESCUENTO_POR_USUARIO = 0.01;
    private static final int NUMERO_DE_USUARIOS_DE_PRUEBA = 3;
	public static final float CONSTANTE_VALOR = (float)103.0;
    public static final float CONSTANTE_VALOR_CON_CERO = (float)100.0;
    public static final float CONSTANTE_VALOR_DE_PRUEBA = (float)100.0;

    @Test
    public void validarCreditosDisponiblesTest() {
        // arrange
        Inscripcion inscripcion = new InscripcionTestDataBuilder().conValor(100).build();
        RepositorioInscripcion repositorioInscripcion = Mockito.mock(RepositorioInscripcion.class);
        Mockito.when(repositorioInscripcion.retornarCreditos(Mockito.anyLong())).thenReturn((float)0);
        ServicioCrearInscripcion servicioCrearInscripcion = new ServicioCrearInscripcion(repositorioInscripcion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearInscripcion.ejecutar(inscripcion), ExcepcionInscripcion.class,"No es posible inscribirte a este curso, no tienes los creditos suficientes");
    }
    
    @Test
    public void validarFechainscripcionTest(){
        // act - assert
        BasePrueba.assertThrows(() ->  new InscripcionTestDataBuilder().conFecha_inscripcion(LocalDate.parse("2021-03-07")).build(), ExcepcionInscripcion.class,"Solo es posible inscribirse a un curso entre semana");
    }

    @Test
    public void validarValorPorcentualTest() {
        // arrange

        Inscripcion inscripcion = new InscripcionTestDataBuilder().conValor(100).build();
        RepositorioInscripcion repositorioInscripcion = Mockito.mock(RepositorioInscripcion.class);
        Mockito.when(repositorioInscripcion.retornarCreditos(Mockito.anyLong())).thenReturn((float)200);
        Mockito.when(repositorioInscripcion.numeroInscritos(Mockito.anyLong())).thenReturn(8);
        ServicioCrearInscripcion servicioCrearInscripcion = new ServicioCrearInscripcion(repositorioInscripcion);
        servicioCrearInscripcion.ejecutar(inscripcion);
        // act - assert
        assertEquals(CONSTANTE_VALOR,inscripcion.getValor(), 0.0);
    }

    @Test
    public void validarValorSinDescuentoTest() {
        // arrange

        Inscripcion inscripcion = new InscripcionTestDataBuilder().conValor(100).build();
        RepositorioInscripcion repositorioInscripcion = Mockito.mock(RepositorioInscripcion.class);
        Mockito.when(repositorioInscripcion.retornarCreditos(Mockito.anyLong())).thenReturn((float)200);
        Mockito.when(repositorioInscripcion.numeroInscritos(Mockito.anyLong())).thenReturn(1);
        ServicioCrearInscripcion servicioCrearInscripcion = new ServicioCrearInscripcion(repositorioInscripcion);
        servicioCrearInscripcion.ejecutar(inscripcion);
        // act - assert
        assertEquals(CONSTANTE_VALOR_CON_CERO,inscripcion.getValor(), 0.0);
    }
    
    
    
    @Test
    public void validarAplicarDescuentoTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    		//Valida el metodo de Aplicar descuento.
    		Method method;
			method = ServicioCrearInscripcion.class.getDeclaredMethod("aplicarDescuento", int.class ,float.class);
			method.setAccessible(true);
			ServicioCrearInscripcion servicio = new ServicioCrearInscripcion(null);
	    	float descuentoAplicado = (float) method.invoke(servicio, (int)NUMERO_DE_USUARIOS_DE_PRUEBA , (float)CONSTANTE_VALOR_DE_PRUEBA );
	    	assertEquals(CONSTANTE_VALOR, descuentoAplicado,0.0);
	    	
    }
    
    
    @Test
    public void validarCostanteNumeroMaximoInsCritosTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {

    	//Valida que la constante que valida el maximo de usuarios incritos no sea diferente de 5
    	Field field = ServicioCrearInscripcion.class.getDeclaredField("NUMERO_MAXIMO_PERMITIDO_INSCRITOS");
    	field.setAccessible(true);
    	int maximoInscritosPermitidos = field.getInt(field);
    	assertEquals(CONSTANTE_DE_USUARIOS_MAXIMO_INSCRITOS_SIN_APLICAR_AUMENTOS, maximoInscritosPermitidos,0.0);
    	
    }
    
    
    @Test
    public void validarCostantePorcentajePorUsuarioTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {
    	
    	//Valida que la constante que valida el valor de porcentaje aplicado por usuario no sea diferente de 0.01
    	Field field = ServicioCrearInscripcion.class.getDeclaredField("CONSTANTE_PORCENTAJE_POR_USUARIO");
    	field.setAccessible(true);
    	double porcentajePorUsuario = field.getDouble(field);
    	assertEquals(PORCENTAJE_DESCUENTO_POR_USUARIO, porcentajePorUsuario,0.0);
    	
    }
    
    
    @Test
    public void validarCostanteCeroTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {
    	
    	//Valida que la constante que valida el valor Cero  no sea modificado
    	Field field = ServicioCrearInscripcion.class.getDeclaredField("CERO");
    	field.setAccessible(true);
    	int cero = field.getInt(field);
    	assertEquals(0, cero,0.0);
    	
    }
    

}
