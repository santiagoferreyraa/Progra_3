package Ejercicios.source.Clase5.Actividad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cambio {
    public static List<Integer> cambioExacto(int[] monedas, int importe){
        Arrays.sort(monedas);
        List<Integer> cambio = new ArrayList<>();

        for (int i = monedas.length - 1; i >= 0 && importe > 0; i--) {
            while (importe >= monedas[i]) {
                cambio.add(monedas[i]);
                importe -= monedas[i];
            }
        }
        return cambio.isEmpty()? null : cambio;
    }
    
    public static void main(String[] args) {
        int[] monedas = {1, 2, 5, 10, 20, 50, 100};
        int importe = 394;
        List<Integer> cambio = cambioExacto(monedas, importe);
        if (cambio!= null)
            System.out.println("El cambio exacto es: " + cambio);
        else
            System.out.println("No hay cambio exacto para el importe dado.");
    }
}

/*
 * En el mejor caso tiene una complejidad de O(n), sino O(nlog n)
 */