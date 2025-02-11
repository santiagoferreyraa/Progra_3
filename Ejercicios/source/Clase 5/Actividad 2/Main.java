//Descripción del Problema:
//Un sistema de tesorería tiene a disposición una variedad de comprobantes que
//incluyen monedas, cheques, bonos y otros documentos financieros. Cada
//comprobante tiene un valor específico. El objetivo es realizar una compra de
//moneda extranjera minimizando el número de comprobantes utilizados.
//Resolver mediante pseudocódigo e implementación java.
//Indicar la complejidad algorítmica.
package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // Definición de los comprobantes y el importe
        List<Integer> comprobantes = new ArrayList<>(Arrays.asList(50, 100, 200, 300, 400, 500, 700, 1000)); // O(1 + n)
        int importe = 250; // O(1)
        List<Integer> resultado = cambioMonedaExtranjera(comprobantes, importe); // O(n.log(n))

        for (int comprobante : resultado) { // O(n)
            System.out.println(comprobante); // O(1)
        }
    }

    public static List<Integer> cambioMonedaExtranjera(List<Integer> comprobantes, int importe) {
        if (importe == 0) return new ArrayList<>(); // O(1)

        // Crear una copia de la lista de comprobantes
        List<Integer> copiaComprobantes = new ArrayList<>(comprobantes); // O(n)
        copiaComprobantes.sort(Collections.reverseOrder()); // O(n.log(n))

        int accum = 0; // O(1)
        List<Integer> resultado = new ArrayList<>(); // O(1)

        // Recorrer los comprobantes
        for (int comprobante : copiaComprobantes) { // O(n)
            while ((accum + comprobante) <= importe) { // O(n)
                accum += comprobante; // O(1)
                resultado.add(comprobante); // O(1)
            }

            if (accum == importe) break; // O(1)
        }

        // Si no se ha podido llegar al importe exacto
        if (accum != importe) { // O(1)
            throw new IllegalArgumentException("No es posible calcular con los valores de los comprobantes actuales"); // O(1)
        }

        return resultado; // O(1)
    }

    // Cálculo de la complejidad total:
    // - O(n) por la copia de la lista
    // - O(n.log(n)) por el ordenamiento
    // - O(n * m) por el bucle anidado (m es el número de veces que se ejecuta el bucle interno)
    // La complejidad total de este algoritmo depende del valor de "importe", 
    // y en el peor de los casos, el bucle interno puede ejecutarse "n" veces para cada comprobante, 
    // lo que da una complejidad de O(n^2).

    // Análisis:
    // 1 + 1 + n + n.log(n) + 1 + 1 + n + n + 1 + 1 = 4 + 4n + n.log(n)
    // En el peor caso, si el importe es grande, el bucle "while" puede ejecutar "n" veces por cada comprobante
    // por lo que la complejidad será O(n^2).

    // f(n) = 4 + 4n + n.log(n) + n^2 pertenece a O(n^2) para c = 18 y n0 = 1.
}