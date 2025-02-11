//Dada una lista de monedas con denominaciones convencionales
//(10,1,5,2,10,10,5,2,5,5,5,5,5,5,10), implementar una función greedy que devuelva
//o genere una lista de monedas para dar cambio exacto utilizando una lista de
//monedas disponible para un importe de $33. Devolver una lista nula o lanzar una
//excepción, si no se puede dar el cambio.
//Realizar pseudocódigo e implementación en Java. Indicar la complejidad
//algorítmica.
package main;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Definición de las monedas y el importe
        List<Integer> monedas = new ArrayList<>(Arrays.asList(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10)); // O(1 + n)
        int importe = 33; // O(1)
        List<Integer> cambio = cambioExacto(monedas, importe); // O(n.log(n))

        System.out.println("Lista de monedas:");
        for (int moneda : cambio) { // O(n)
            System.out.println(moneda); // O(1)
        }
    }

    public static List<Integer> cambioExacto(List<Integer> monedas, int importe) {
        // Crear una copia de la lista de monedas
        List<Integer> copiaMonedas = new ArrayList<>(monedas); // O(n)
        copiaMonedas.sort(Collections.reverseOrder()); // O(n.log(n))

        int accum = 0; // O(1)
        List<Integer> cambio = new ArrayList<>(); // O(1)
        for (int moneda : copiaMonedas) { // O(n)
            if (accum == importe) break; // O(1)
            if ((accum + moneda) <= importe) { // O(2n)
                accum += moneda; // O(1)
                cambio.add(moneda); // O(1)
            }
        }

        // Si no se ha podido llegar al importe exacto
        if (accum != importe) { // O(1)
            throw new IllegalArgumentException("No es posible calcular el cambio exacto"); // O(1)
        }

        return cambio; // O(1)
    }

    // Cálculo de la complejidad total:
    // - O(n) por la copia de la lista
    // - O(n.log(n)) por el ordenamiento
    // - O(n) por el recorrido en el for
    // La complejidad total de este algoritmo es: O(n.log(n))

    // Análisis:
    // 1 + 1 + n + n.log(n) + 1 + 1 + n + 2n + 1 + 1 = 4 + 4n + n.log(n)
    // 4 + 4n + n.log(n) <= c * n.log(n)
    // 4/n.log(n) + 4 + 1 <= c
    // n0 == 1
    // 4 + 4 + 1 <= c
    // 9 <= c
    // f(n) = 4 + 4n + n.log(n) pertenece a O(n.log(n)) para c = 9 y n0 = 1.
}