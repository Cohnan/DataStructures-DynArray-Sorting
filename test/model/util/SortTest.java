package model.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.util.Sort;

public class SortTest {

	// Muestra de datos a ordenar
	private Comparable[] datos;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("Codigo de configuracion de muestra de datos a probar");
	}

	@Test
	public void test() {
		Sort.ordenarMergeSort(datos);
		fail("Not yet implemented");
	}

}
