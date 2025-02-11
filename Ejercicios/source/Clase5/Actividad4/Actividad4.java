package Ejercicios.source.Clase5.Actividad4;

import java.util.ArrayList;
import java.util.Collections;

public class Actividad4 {
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
}