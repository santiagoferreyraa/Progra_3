package Ejercicios.Clase5.Actividad1;

import java.util.ArrayList;

public class Actividad1 {
    public static ArrayList<Integer> CambioExacto(int[] lista) {
        ArrayList<Integer> resultado = new ArrayList<>(); // O(1)
        int[] aux = lista.clone(); // O(1 + n)
        int suma = 33; // O(1)
        mergeSort(aux); // O(n.log(n))

        for (int i = aux.length - 1; i >= 0; i--) { // O(3 + n + 2n)
            if (suma - aux[i] >= 0) { // O(2n)
                resultado.add(aux[i]); // O(n)
                suma -= aux[i]; // O(2n)

            } else if (suma == 0) {
                break;
            }
        }

        if (suma > 0) { // O(1)
            return null; // O(1)

        } else {
            return resultado;
        }

        // 1 + 1 + n + 1 + n.log(n) + 3 + n + 2n + 2n + n + 2n + 1 + 1 = 8 + 9n + n.log(n) <= c.n
        //                                                                8/n + 9 + log(n) <= c
        //                                                                              n0 == 1
        //                                                                       8 + 9 + 0 <= c
        //                                                                              17 <= c
        // f(n) = 8 + 9n + n.log(n) pertenece a O(n.log(n)) para c = 17 y n0 = 1.
    }

    public static void main(String[] args) {
        int[] monedas = {10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10};
        ArrayList<Integer> resultado = CambioExacto(monedas);

        for (Integer i : resultado) {
            System.out.print(i + " ");
        }

    }

    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; // Si el arreglo tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = arreglo.length / 2;

        // Dividir el arreglo en dos mitades
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];

        // Copiar los elementos a las mitades
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(arreglo, izquierda, derecha);
    }

    // Método para mezclar dos mitades ordenadas
    private static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
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
}
