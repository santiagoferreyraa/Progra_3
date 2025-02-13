package Ejercicios.source.Clase4.Actividad3;

import Ejercicios.source.Clase4.Actividad1.Cliente;

import java.util.Arrays;

public class Actividad3 {
    public static void MergeSortClientes(Cliente[] arreglo) {
        if (arreglo.length < 2) {
            return;
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        Cliente[] izquierda = new Cliente[medio];
        Cliente[] derecha = new Cliente[arreglo.length - medio];

        // Copiar los elementos a las mitades
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        MergeSortClientes(izquierda);
        MergeSortClientes(derecha);

        // Mezclar las mitades ordenadas
        Merge(arreglo, izquierda, derecha);
    }

    // Método para mezclar dos mitades ordenadas
    private static void Merge(Cliente[] arreglo, Cliente[] izquierda, Cliente[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].getScoring() <= derecha[j].getScoring()) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    public static Cliente[] Juntar(Cliente[] arreglo1, Cliente[] arreglo2) {
        Cliente[] juntar = new Cliente[arreglo1.length + arreglo2.length]; // O(4)

        for (int i = 0; i < arreglo1.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            juntar[i] = arreglo1[i]; // O(n)
        }

        for (int i = 0; i < arreglo2.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            juntar[i + arreglo1.length] = arreglo2[i]; // O(3n)
        }

        MergeSortClientes(juntar); // O(n.log(n))
        Cliente[] resultado = Arrays.copyOfRange(juntar, juntar.length - 2, juntar.length); // O(6) porque devuelve 2.

        return resultado; // O(1)

        // 4 + 1 + 3n + n + 1 + 3n + 3n + n.log(n) + 6 + 1 = 13 + 10n + n.log(n) <= c.n
        //                                                    13/n + 10 + log(n) <= c
        //                                                                    n0 == 1
        //                                                           13 + 10 + 0 <= c
        //                                                                    23 <= c
        // f(n) = 13 + 10n + n.log(n) pertenece a O(n.log(n)) para c = 23 y n0 = 1.
    }

    public static Cliente[] ScoringMaximo(Cliente[] arreglo) {
        if (arreglo == null || arreglo.length == 0) { // O(4)
            return null; // O(1)
        }

        if (arreglo.length == 1) { // O(2)
            return new Cliente[]{arreglo[0]}; // O(1)
        }

        int mitad = arreglo.length / 2; // O(3)
        Cliente[] izq = ScoringMaximo(Arrays.copyOfRange(arreglo, 0, mitad)); // T(n/2)
        Cliente[] der = ScoringMaximo(Arrays.copyOfRange(arreglo, mitad, arreglo.length)); // T(n/2)

        Cliente[] resultado = Juntar(izq, der); // O(n.log(n))

        return resultado; // O(1)

        // T(n) = 2.T(n/2) + O(12 + n.log(n))
        // a = b^k
        // 2 = 2^1
        // Como a = b^k, la complejidad es O(n.log(n)) por el teorema maestro.
    }

    public static void main(String[] args) {
        Cliente[] arreglo = new Cliente[4];

        Cliente cliente1 = new Cliente("Juan", 1, 2);
        Cliente cliente2 = new Cliente("Juli", 2, 4);
        Cliente cliente3 = new Cliente("Santi", 3, 1);
        Cliente cliente4 = new Cliente("Santi", 4, 5);

        arreglo[0] = cliente1;
        arreglo[1] = cliente2;
        arreglo[2] = cliente3;
        arreglo[3] = cliente4;

        Cliente[] resultado = ScoringMaximo(arreglo);

        for (int i = 0; i < resultado.length; i++) {
            System.out.println(resultado[i]);
        }
    }
}
