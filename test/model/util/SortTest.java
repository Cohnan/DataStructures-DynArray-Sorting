package model.util;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.util.Sort;

public class SortTest {

	// Muestra de datos a ordenar
	private Integer[] datos = new Integer[]{6,4,6, 7, 3, 5, 2, 7, 3, 8, 2, 5, 2, 5, 8, 3, 1, 6, 8, 12, 34, 57, 43, 67, 23, 5, 43, 13, 64, 72, 99};
	
	@Before
	public void setUp() throws Exception{
		System.out.println("Codigo de configuracion de muestra de datos a probar");
	}

	@Test
	public void test() {
		
		Comparable[] datosOrdenados = Arrays.copyOf(datos, datos.length);
		Arrays.sort(datosOrdenados);
		/*
		System.out.println("Antes del test: ");
		for (int i = 0; i < datos.length; i++) {
			System.out.print(datos[i] + " ");
		}
		System.out.println("");
		*/
		Sort.ordenarShellSort(datos);
		/*
		System.out.println("Despues del test: ");
		for (int i = 0; i < datos.length; i++) {
			System.out.print(datos[i] + " ");
		}
		System.out.println("");
		*/
		for (int i = 0; i < datos.length; i++) {
			assertTrue(datos[i].equals(datosOrdenados[i]));
		}
		
	}

}
