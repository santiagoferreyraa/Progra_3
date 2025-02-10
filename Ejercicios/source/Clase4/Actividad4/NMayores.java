package Ejercicios.source.Clase4.Actividad4;

import Ejercicios.source.Clase3.Actividad4.MergeSort;

import java.util.Arrays;

public class NMayores {
    public static int[] Combinar(int[] arreglo1, int[] arreglo2, int n) {
        int[] combine = new int[arreglo1.length + arreglo2.length]; // O(1)

        for (int i = 0; i < arreglo1.length; i++) {         //   O(1 + 3n)
            combine[i] = arreglo1[i];                       // O(n)
        }

        for (int i = 0; i < arreglo2.length; i++) {              //O(1 + 3n)
            combine[i + arreglo1.length] = arreglo2[i];             // O(2n)
        }

        MergeSort.mergeSort(combine);                           // O(n.log(n))
        int[] resultado = Arrays.copyOfRange(combine, combine.length - n, combine.length);      // O(n)

        return resultado;               // O(1)

    /*   
        c => 4/n + 10 + log(n)
        n0 == 1
        c => 4 + 10 + log(1)
        c => 14 
        f(n) = 4 + 10n + n.log(n) pertenece a O(n.log(n)) para c = 14 y n0 = 1.
    */
    }

    public static int[] mayores(int[] arreglo, int n) {
        if (arreglo.length <= n) { // O(1)
            return arreglo; // O(1)
        }

        int mitad = arreglo.length / 2; // O(2)
        int[] izq = mayores(Arrays.copyOfRange(arreglo, 0, mitad), n); // T(n/2)
        int[] der = mayores(Arrays.copyOfRange(arreglo, mitad, arreglo.length), n); // T(n/2)

        int[] resultado = Combinar(izq, der, n); // O(n.log(n))

        return resultado; // O(1)

        // T(n) = 2.T(n/2) + O(5 + n.log(n))
        // a = b^k
        // 2 = 2^1
        // Como a = b^k, la complejidad es O(n.log(n)) por el teorema maestro.
    }

    public static void main(String[] args) {
        int[] arreglo = {4,5,8,2,9,5,3,2};

        int[] resultado = mayores(arreglo, 5);

        for (int i = 0; i < resultado.length; i++) {
            System.out.println(resultado[i]);
        }
    }
}

