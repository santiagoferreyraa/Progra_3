package Ejercicios.source.Clase7.Actividad4;

import java.util.ArrayList;
import java.util.List;

public class SeleccionPaquetesInversion {
    private static int[][] calcularMatrizGanancias(int[] costosPaquetes, int[] gananciasEstimadas, int presupuestoDisponible) {
        int cantidadPaquetes = costosPaquetes.length;
        int[][] matrizGanancias = new int[cantidadPaquetes + 1][presupuestoDisponible + 1];

        for (int i = 1; i <= cantidadPaquetes; i++) {
            int costoPaquete = costosPaquetes[i - 1];
            int gananciaEstimada = gananciasEstimadas[i - 1];

            for (int j = 1; j <= presupuestoDisponible; j++) {
                if (costoPaquete > j) {
                    matrizGanancias[i][j] = matrizGanancias[i - 1][j];
                } else {
                    matrizGanancias[i][j] = Math.max(matrizGanancias[i - 1][j], gananciaEstimada + matrizGanancias[i - 1][j - costoPaquete]);
                }
            }
        }

        return matrizGanancias;
    }

    private static List<Integer> identificarPaquetesOptimos(int[][] matrizGanancias, int[] costosPaquetes, int presupuestoDisponible) {
        List<Integer> paquetesSeleccionados = new ArrayList<>();
        int i = costosPaquetes.length;
        int j = presupuestoDisponible;

        while (i > 0 && j > 0) {
            if (matrizGanancias[i][j] != matrizGanancias[i - 1][j]) {
                paquetesSeleccionados.add(i);
                j -= costosPaquetes[i - 1];
            }
            i--;
        }

        return paquetesSeleccionados;
    }

    public static void maximizarGanancias(int[] costosPaquetes, int[] gananciasEstimadas, int presupuestoDisponible) {
        int[][] matriz = calcularMatrizGanancias(costosPaquetes, gananciasEstimadas, presupuestoDisponible);
        List<Integer> paquetesOptimos = identificarPaquetesOptimos(matriz, costosPaquetes, presupuestoDisponible);
        int gananciaMaxima = matriz[matriz.length - 1][matriz[0].length - 1];

        System.out.print("La ganancia máxima posible es " + gananciaMaxima + " obtenida con los paquetes de inversión:");
        for (Integer paquete : paquetesOptimos) {
            System.out.print(" " + paquete);
        }
    }

    public static void main(String[] args) {
        int[] costosPaquetes = {12, 20, 15, 25};
        int[] gananciasEstimadas = {150, 200, 100, 300};
        int presupuestoDisponible = 35;

        maximizarGanancias(costosPaquetes, gananciasEstimadas, presupuestoDisponible);
    }
}
