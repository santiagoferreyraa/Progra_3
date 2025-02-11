package main;
import java.util.ArrayList;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[] lista = {3, 2, 1, 4, 5, 6};
		System.out.println(sumaPrimerosNumeros(lista, n));
	}
	
	public static int sumaPrimerosNumeros(int[] lista, int n) {
		if(n >= lista.length) {
			throw new IllegalArgumentException("El número de elementos a sumar debe ser menor o igual a la cantidad de elementos de la lista");
		}
		else if(n <= 0) {
			throw new IllegalArgumentException("El número de elementos a sumar debe ser mayor a 0");
		}
		return sumaPrimerosNumerosRecursivo(lista, n, 0);
	}
	
	public static int sumaPrimerosNumerosRecursivo(int[] lista, int n, int indice) {
		if(n == indice) {
			return 0;
		}
		else {
			return lista[indice] + sumaPrimerosNumerosRecursivo(lista, n, indice + 1);
		}
	}
}

