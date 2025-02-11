package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CostoMinimo {
	public static int getMinimumCost(int k, int[] c) {
        ArrayList<Integer> aux = new ArrayList<>();

        for (int i = 0; i < c.length; i++) {
            aux.add(c[i]);
        }

        aux.sort(Collections.reverseOrder());
        int suma = -1;
        int resultado = 0;

        for (int i = 0; i < aux.size(); i++) {
            if (i % k == 0) {
                suma++;
            }
            resultado += (suma + 1) * aux.get(i);
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Ejemplo de array de costos
        int[] costos = {1, 2, 3, 4};
        
        // Número de personas en un grupo (k)
        int k = 3;

        // Llamada al método getMinimumCost y salida del resultado
        int costoMinimo = CostoMinimo.getMinimumCost(k, costos);
        System.out.println("El costo mínimo es: " + costoMinimo);
    }
}