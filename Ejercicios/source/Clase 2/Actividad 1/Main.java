// Dada esta matriz: int[][] mat = {{4,5,6},{7,8,9},{5,6,7}};
// Realizar un programa en java para calcular el promedio.
// Para los cálculos, asumir que la matriz es cuadrada
// Realizar el conteo de instrucciones.
// Calcular la complejidad asintótica.
package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matriz = {{4,5,6},{7,8,9},{5,6,7}};
		int suma = 0; // 1
		
		for (int i = 0; i < matriz.length; i++) { // 1 + 2 (n+1) + n = 3 + 3n
			for (int j = 0; j < matriz[0].length; j++) { // 1 + 2 (n+1) + n = 3 + 3n
				suma += matriz[i][j]; // 2n
			}
		}
		
		double promedio = ( (double) suma / (matriz.length*matriz[0].length)); // 2
		System.out.println("Promedio " + promedio ); // 2
	}

}
// f(n) = 1 + 3 + 3n + n ( 3 + 3n + 2n ) + 2 + 2 = 6 + 3n + n (3 + 5n )
// f(n) = 6 + 3n + 3n + 5n^2 = 6 + 6n + 5 n^2
// demostracion
// f(n) = 6 + 6n + 5 n^2 pertenece a O(n^2)
// 6 + 6n + 5 n^2 <= c n^2
// 6/n^2 + 6n/n^2 + 5 n^2/n^2 <= c n^2/n^2
// 6/n^2 + 6n/n^2 + 5 <= c
// n = 1 6 + 6 + 5 <= 17
// n = 2 6/4 + 6 * 2/ 4 + 5 <= 17
// c = 17
// f(n) = 6 + 6n + 5 n^2 pertenece a O(n^2) para c = 17 y n0 = 1