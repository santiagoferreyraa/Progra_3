//Problema: Selección óptima de proyectos
//Eres el gerente de una empresa que debe decidir en qué proyectos invertir. Cada
//proyecto tiene un costo asociado y un beneficio esperado. Tienes un presupuesto
//limitado y necesitas elegir qué combinación de proyectos maximiza el beneficio
//total sin exceder el presupuesto.
//Requerimientos:
//Te proporcionarán un arreglo de costos que representa el costo de cada proyecto.
//También te proporcionarán un arreglo de beneficios que indica el beneficio que se
//espera de cada proyecto.
//Implementa un algoritmo que determine qué proyectos deben seleccionarse para
//maximizar el beneficio total sin exceder el presupuesto.
//Actividad 3
//Supón que tienes los siguientes datos:
//Costos de los proyectos: [10, 15, 20, 25]
//Beneficios esperados de los proyectos: [100, 200, 150, 300]
//Presupuesto disponible: 40
//El programa debe calcular cuál es el beneficio máximo que puedes obtener
//respetando el presupuesto disponible y los proyectos seleccionados.
//Calcular utilizando algoritmos de programación dinámica. Indicar complejidades.
package main;

import java.util.*;

public class Main {
    public static int beneficioMaximo(int[] costos, int[] beneficios, int presupuesto, List<Integer> solucion) {
        int n = costos.length; // 1
        int[][] dp = new int[n + 1][presupuesto + 1]; // 1

        for (int i = 1; i <= n; i++) { // 1 + n + 1 + 2n = 2 + 3n
            for (int j = 0; j <= presupuesto; j++) { // 2 + 3p
                if (costos[i - 1] <= j) { // p
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + beneficios[i - 1]); // 3p
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
        int[] costos = {10, 15, 20, 25}; // 1
        int[] beneficios = {100, 200, 150, 300}; // 1
        int presupuesto = 40; // 1
        List<Integer> solucion = new ArrayList<>(); // 1
        
        for(int i = 0; i < costos.length; i++) { // 2 + 3n
            System.out.println("Proyecto " + (i+1) + "\nCosto:" + costos[i] + "\nBeneficio Esperado: " + beneficios[i] + "\n"); // 3n
        }
        
        System.out.println("Beneficio Maximo: " + beneficioMaximo(costos, beneficios, presupuesto, solucion)); // 1
        System.out.println("Proyectos seleccionados: " + solucion); // 1
    }
}
