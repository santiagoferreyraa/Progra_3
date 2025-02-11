//Problema: Selección de paquetes de inversión
//Eres un gestor financiero y tienes la tarea de seleccionar entre varios paquetes de
//inversión para maximizar las ganancias. Cada paquete tiene un costo inicial y una
//ganancia estimada. Sin embargo, tu presupuesto es limitado, por lo que debes elegir
//cuidadosamente qué paquetes comprar para maximizar las ganancias sin exceder el
//presupuesto.
//Requerimientos:
//Te proporcionarán un arreglo de costos, donde cada elemento representa el costo de un
//paquete de inversión.
//También recibirás un arreglo de ganancias que representa la ganancia esperada de
//cada paquete.
//Debes implementar un algoritmo que determine la combinación de paquetes que
//maximiza las ganancias totales sin superar el presupuesto disponible.
package main;

import java.util.*;

public class Main {
	
	public static int beneficioMaximo(int[] costos, int[] ganancias, int presupuesto, List<Integer> solucion) {
        int n = costos.length; // 1
        int[][] dp = new int[n + 1][presupuesto + 1]; // 1

        for (int i = 1; i <= n; i++) { // 1 + n + 1 + 2n = 2 + 3n
            for (int j = 0; j <= presupuesto; j++) { // 2 + 3p
                if (costos[i - 1] <= j) { // p
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancias[i - 1]); // 3p
                } else {
                    dp[i][j] = dp[i - 1][j]; // p
                }
            }
        }
        
        int j = presupuesto; // 1
        for (int i = n; i > 0 && j > 0; i--) { // 2 + 3n
            if (dp[i][j] != dp[i - 1][j]) { // n
                solucion.add(i); // n
                j -= costos[i - 1]; // n
            }
        }
        
        // Complejidad total:
        // 2 + 3n + n * (2 + 3p + p + 3p + p) + (2 + 3n + n + n + n)
        // 2 + 3n + n * (2 + 8p) + (2 + 6n)
        // 4 + 9n + 8np
        // f(n, p) = 4 + 9n + 8np
        // 
        // Demostración:
        // 4 + 9n + 8np <= c * np
        // 4/np + 9n/np + 8np/np <= c * np/np
        // 4/np + 9/n + 8 <= c
        // n0 = 1, p0 = 1
        // 4 + 9 + 8 <= c
        // 4 + 9 + 8 <= 21
        // f(n, p) pertenece a O(n*p) para c = 21 y n0 = 1, p0 = 1

        return dp[n][presupuesto];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] costos = {12, 20, 15, 25}; // 1
		int[] ganancias = {150, 200, 100, 300}; // 1
		int presupuesto = 35; // 1
		List<Integer> solucion = new ArrayList<>(); // 1
		
		for(int i = 0; i < costos.length; i++) { // 2 + 3n
			System.out.println("Proyecto " + (i+1) + "\nCosto:" + costos[i] + "\nBeneficio Esperado: " + ganancias[i] + "\n"); // 3n
		}
		
		System.out.println("Beneficio Maximo: " + beneficioMaximo(costos, ganancias, presupuesto, solucion)); // 1

		System.out.println("Paquetes seleccionados: " + solucion); // 1
		
	}
}
