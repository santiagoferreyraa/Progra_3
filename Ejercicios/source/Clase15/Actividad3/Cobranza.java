package Ejercicios.source.Clase15.Actividad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cobranza {
    public static void cobrador(int monto_inicial, Integer[] sucursales) {
        Arrays.sort(sucursales, Collections.reverseOrder());
        List<Integer> sucursales_recorridas = new ArrayList<>();

        for (Integer i : sucursales) {
            if (monto_inicial + i > 0) {
                monto_inicial += i;
                sucursales_recorridas.add(i);
            }
        }

        System.out.println(monto_inicial);
        System.out.println(sucursales_recorridas);
    }

    public static void main(String[] args) {
        Integer[] sucursales = {100, 50, 120, -100, -200, -300, 500};
        int monto_inicial = 70;

        cobrador(monto_inicial, sucursales);
    }
}