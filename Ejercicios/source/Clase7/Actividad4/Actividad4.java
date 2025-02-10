package Ejercicios.source.Clase7.Actividad4;

import java.util.ArrayList;
import java.util.List;

public class Actividad4 {
    private static int[][] MatrizPD(int[] costosPaquetes, int[] gananciasEsperadas, int presupuesto) {
        int cantidadPaquetes = costosPaquetes.length; // O(2)
        int[][] matrizPD = new int[cantidadPaquetes + 1][presupuesto + 1]; // O(4)

        for (int i = 1; i <= cantidadPaquetes; i++) { // O(1 + n + 2n) = O(1 + 3n)
            int costoPaquete = costosPaquetes[i - 1]; // O(2n)
            int gananciaEsperada = gananciasEsperadas[i - 1]; // O(2n)

            for (int j = 1; j <= presupuesto; j++) { // O(n + n^2 + 2n^2) = O(n + 3n^2)
                if (costoPaquete > j) { // O(n^2)
                    matrizPD[i][j] = matrizPD[i - 1][j];
                } else {
                    matrizPD[i][j] = Math.max(matrizPD[i - 1][j], gananciaEsperada + matrizPD[i - 1][j - costoPaquete]); // O(5n^2)
                }
            }
        }

        return matrizPD; // O(1)

        // 2 + 4 + 1 + 3n + 2n + 2n + n + 3n^2 + n^2 + 5n^2 + 1 = 8 + 8n + 9n^2 <= c.n
        //                                                         8/n + 8 + 9n <= c
        //                                                                   n0 == 1
        //                                                            8 + 8 + 9 <= c
        //                                                                   25 <= c
        // f(n) = 8 + 8n + 9n^2 pertenece a O(n^2) para c = 25 y n0 = 1.
    }

    private static List<Integer> MejoresPaquetes(int[][] matrizPD, int[] costosPaquetes, int presupuesto) {
        List<Integer> mejoresPaquetes = new ArrayList<>(); // O(1)
        int i = costosPaquetes.length;  // O(2)
        int j = presupuesto;            // O(1)

        while (i > 0 && j > 0) { // O(n)
            if (matrizPD[i][j] != matrizPD[i - 1][j]) { // O(2n)
                mejoresPaquetes.add(i); // O(n)
                j -= costosPaquetes[i - 1]; // O(3n)
            }
            i--; // O(2n)
        }

        return mejoresPaquetes; // O(1)

        // 1 + 2 + 1 + n + 2n + n + 3n + 2n + 1 = 5 + 9n <= c.n
        //                                       5/n + 9 <= c
        //                                            n0 == 1
        //                                         5 + 9 <= c
        //                                            14 <= c
        // f(n) = 5 + 9n pertenece a O(n) para c = 14 y n0 = 1.
    }

    public static void MaximizarGanancia(int[] costosPaquetes, int[] gananciasEsperadas, int presupuesto) {
        int[][] matriz = MatrizPD(costosPaquetes, gananciasEsperadas, presupuesto); // O(1 + n^2)
        List<Integer> mejoresPaquetes = MejoresPaquetes(matriz, costosPaquetes, presupuesto); // O(1 + n)
        int mejorGanancia = matriz[matriz.length - 1][matriz[0].length - 1]; // O(6)

        System.out.print("La mejor ganancia a obtener es " + mejorGanancia + " con los paquetes"); // O(3)

        for (Integer i : mejoresPaquetes) { // O(1 + n + 2n) = O (1 + 3n)
            System.out.print(" " + i); // O(2n)
        }

        // 1 + n^2 + 1 + n + 6 + 3 + 1 + 3n + 2n = 12 + 6n + n^2 <= c.n
        //                                          12/n + 6 + n <= c
        //                                                    n0 == 1
        //                                            12 + 6 + 1 <= c
        //                                                    19 <= c
        // f(n) = 12 + 6n + n^2 pertenece a O(n^2) para c = 19 y n0 = 1.
    }

    public static void main(String[] args) {
        int[] costosPaquetes = {12, 20, 15, 25};
        int[] gananciasEsperadas = {150, 200, 100, 300};
        int presupuesto = 35;
        MaximizarGanancia(costosPaquetes, gananciasEsperadas, presupuesto);
        // La complejidad total del programa es O(n^2).
    }
}
