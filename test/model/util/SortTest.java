package model.util;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

import model.util.Sort;

public class SortTest {
	/*
	 * Constantes
	 */
	// Tamano de la muestra
	private final int N = 3;
	// Numero de escenarios de prueba
	private final int totalEscenarios = 3;
	
	/*
	 * Atributos
	 */
	// Muestra de datos a ordenar
	Comparable[] datos;
	
	/**
	 * Establece los escenarios de prueba
	 * @param n Numero de escenario de prueba a configurar
	 */
	private void setUpEscenario(int n) {
		if (n >= totalEscenarios) throw new IllegalArgumentException("No hay tantos escenarios");
		datos = new Comparable[N];
		switch(n) {
		// Escenario: muestra ya ordenada
		case 0:
			for(int i = 0; i < N; i++) datos[i] = (Comparable) (i/2);
			break;
		// Escenarios: muestra totalmente desordenada
		case 1:
			for(int i = 0; i < N; i++) datos[i] = (Comparable) ((N-1-i)/2);
			break;
		// Escenario: muestra aleatoria
		case 2:
			for(int i = 0; i < N; i++) datos[i] = (Comparable) Math.random();
			break;
		}
	}
	
	/**
	 * Prueba de ShellSort
	 */
	@Test
	public void testShellSort() {
		Comparable[] datosOrdenados;
				
		for (int n = 0; n < totalEscenarios; n++) {
			setUpEscenario(n);
				
			datosOrdenados = Arrays.copyOf(datos, datos.length);
			Arrays.sort(datosOrdenados);
			Sort.ordenarShellSort(datos);
			
			for (int i = 0; i < N; i++) {
				System.out.print(datos[i] + " ");
			} System.out.println("");
			
			for (int i = 0; i < datos.length; i++) {
				assertTrue(datos[i].equals(datosOrdenados[i]));
			}
		}
	}
	
	/**
	 * Prueba de MergeSort
	 */
	@Test
	public void testMergeSort() {
		Comparable[] datosOrdenados;
				
		for (int n = 0; n < totalEscenarios; n++) {
			setUpEscenario(n);
				
			datosOrdenados = Arrays.copyOf(datos, datos.length);
			Arrays.sort(datosOrdenados);
			Sort.ordenarMergeSort(datos);
			
			for (int i = 0; i < datos.length; i++) {
				assertTrue(datos[i].equals(datosOrdenados[i]));
			}
		}
	}
	
	/**
	 * Prueba de QuickSort
	 */
	@Test
	public void testQuickSort() {
		Comparable[] datosOrdenados;
				
		for (int n = 0; n < totalEscenarios; n++) {
			setUpEscenario(n);
			System.out.println("Configura el escenario: " + n);
				
			datosOrdenados = Arrays.copyOf(datos, datos.length);
			Arrays.sort(datosOrdenados);
			Sort.ordenarQuickSort(datos);
			
			for (int i = 0; i < N; i++) {
				System.out.print(datos[i] + " ");
			} System.out.println("");
			
			for (int i = 0; i < datos.length; i++) {
				assertTrue("Falla en esc " + n, datos[i].equals(datosOrdenados[i]));
			}
		}
	}
}
