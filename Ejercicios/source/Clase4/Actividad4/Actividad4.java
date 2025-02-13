package Ejercicios.source.Clase4.Actividad4;

import java.util.Arrays;
import Ejercicios.source.Clase3.Actividad4.MergeSort;

public class Actividad4 {
    public static int[] Juntar(int[] arreglo1, int[] arreglo2, int n) {
        int[] juntar = new int[arreglo1.length + arreglo2.length]; // O(1)

        for (int i = 0; i < arreglo1.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            juntar[i] = arreglo1[i]; // O(n)
        }

        for (int i = 0; i < arreglo2.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            juntar[i + arreglo1.length] = arreglo2[i]; // O(2n)
        }

        MergeSort.mergeSort(juntar); // O(n.log(n))
        int[] resultado = Arrays.copyOfRange(juntar, juntar.length - n, juntar.length); // O(n)

        return resultado; // O(1)

    // 1 + 1 + 3n + n + 1 + 3n + 2n + n.log(n) + n + 1 = 4 + 10n + n.log(n) <= c.n
    //                                                    4/n + 10 + log(n) <= c
    //                                                                   n0 == 1
    //                                                      4 + 10 + log(1) <= c
    //                                                                   14 <= c
    // f(n) = 4 + 10n + n.log(n) pertenece a O(n.log(n)) para c = 14 y n0 = 1.
    }

    public static int[] NMayores(int[] arreglo, int n) {
        if (arreglo.length <= n) { // O(1)
            return arreglo; // O(1)
        }

        int mitad = arreglo.length / 2; // O(2)
        int[] izq = NMayores(Arrays.copyOfRange(arreglo, 0, mitad), n); // T(n/2)
        int[] der = NMayores(Arrays.copyOfRange(arreglo, mitad, arreglo.length), n); // T(n/2)

        int[] resultado = Juntar(izq, der, n); // O(n.log(n))

        return resultado; // O(1)

        // T(n) = 2.T(n/2) + O(5 + n.log(n))
        // a = b^k
        // 2 = 2^1
        // Como a = b^k, la complejidad es O(n.log(n)) por el teorema maestro.
    }

    public static void main(String[] args) {
        int[] arreglo = {4,5,8,2,9,5,3,2};

        int[] resultado = NMayores(arreglo, 5);

        for (int i = 0; i < resultado.length; i++) {
            System.out.println(resultado[i]);
        }
    }
}
