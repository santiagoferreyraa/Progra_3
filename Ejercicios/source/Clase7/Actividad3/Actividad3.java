package Ejercicios.Clase7.Actividad3;

import java.util.ArrayList;
import java.util.List;

public class Actividad3 {
    private static int[][] MatrizPD(int[] costosProyectos, int[] beneficiosProyectos, int presupuestoMax) {
        int cantProyectos = costosProyectos.length; // O(2)
        int[][] matrizPD = new int[cantProyectos + 1][presupuestoMax + 1]; // O(3)

        for (int i = 1; i <= cantProyectos; i++) { // O(1 + 3n)
            int costoProyecto = costosProyectos[i - 1]; // O(2n)
            int beneficioProyecto = beneficiosProyectos[i - 1]; // O(2n)

            for (int j = 1; j <= presupuestoMax; j++) { // O(n + 3n^2)
                if (costoProyecto > j) { // O(n^2)
                    matrizPD[i][j] = matrizPD[i - 1][j];
                } else {
                    matrizPD[i][j] = Math.max(matrizPD[i - 1][j], beneficioProyecto + matrizPD[i - 1][j - costoProyecto]); // O(6n^2)
                }
            }
        }

        return matrizPD; // O(1)

        // 2 + 3 + 1 + 3n + 2n + 2n + n + 3n^2 + n^2 + 6n^2 + 1 = 7 + 8n + 10n^2 <= c.n
        //                                                         7/n + 8 + 10n <= c
        //                                                                    n0 == 1
        //                                                            7 + 8 + 10 <= c
        //                                                                    25 <= c
        // f(n) = 7 + 8n + 10n^2 pertenece a O(n^2) para c = 25 y n0 = 1.
    }

    private static List<Integer> MejoresProyectos(int[][] matrizPD, int[] costosProyectos, int presupuestoMax) {
        List<Integer> mejoresProyectos = new ArrayList<>(); // O(1)
        int i = costosProyectos.length; // O(2)
        int j = presupuestoMax; // O(1)

        while (i > 0 && j > 0) { // O(2n)
            if (matrizPD[i][j] != matrizPD[i - 1][j]) { // O(2n)
                mejoresProyectos.add(i); // O(n)
                j -= costosProyectos[i - 1]; // O(3n)
            }
            i--; // O(2n)
        }

        return mejoresProyectos; // O(1)

        // 1 + 2 + 1 + 2n + 2n + n + 3n + 2n + 1 = 5 + 10n <= c.n
        //                                        5/n + 10 <= c
        //                                              n0 == 1
        //                                          5 + 10 <= c
        //                                              15 <= c
        // f(n) = 5 + 10n pertenece a O(n) para c = 15 y n0 = 1.
    }

    public static void MaximizarBeneficio(int[] costosProyectos, int[] beneficiosProyectos, int presupuestoMax) {
        int[][] matriz = MatrizPD(costosProyectos, beneficiosProyectos, presupuestoMax); // O(n^2)
        List<Integer> mejoresProyectos = MejoresProyectos(matriz, costosProyectos, presupuestoMax); // O(n)
        int mejorBeneficio = matriz[matriz.length - 1][matriz[0].length - 1]; // O(5)

        System.out.print("El mejor beneficio a obtener es " + mejorBeneficio + " con los proyectos"); // O(1)

        for (Integer i : mejoresProyectos) { // O(1 + 3n)
            System.out.print(" " + i); // O(2n)
        }

        // n^2 + n + 5 + 1 + 1 + 3n + 2n = 7 + 6n + n^2 <= c.n
        //                                  7/n + 6 + n <= c
        //                                           n0 == 1
        //                                    7 + 6 + 1 <= c
        //                                           14 <= c
        // f(n) = 7 + 6n + n^2 pertenece a O(n^2) para c = 14 y n0 = 1.
    }

    public static void main(String[] args) {
        int[] costosProyectos = {10, 15, 20, 25};
        int[] beneficiosProyectos = {100, 200, 150, 300};
        int presupuestoMax = 40;
        MaximizarBeneficio(costosProyectos, beneficiosProyectos, presupuestoMax);
    }
}
