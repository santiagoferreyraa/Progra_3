package Ejercicios.source.Clase7.Actividad3;

import java.util.ArrayList;
import java.util.List;

public class OptimizacionProyectos {
    private static int[][] construirMatrizDP(int[] costos, int[] beneficios, int presupuesto) {
        int totalProyectos = costos.length;
        int[][] tablaDP = new int[totalProyectos + 1][presupuesto + 1];

        for (int proyecto = 1; proyecto <= totalProyectos; proyecto++) {
            int costoActual = costos[proyecto - 1];
            int beneficioActual = beneficios[proyecto - 1];

            for (int capacidad = 1; capacidad <= presupuesto; capacidad++) {
                if (costoActual > capacidad) {
                    tablaDP[proyecto][capacidad] = tablaDP[proyecto - 1][capacidad];
                } else {
                    tablaDP[proyecto][capacidad] = Math.max(
                        tablaDP[proyecto - 1][capacidad], 
                        beneficioActual + tablaDP[proyecto - 1][capacidad - costoActual]
                    );
                }
            }
        }
        return tablaDP;
    }

    private static List<Integer> obtenerProyectosSeleccionados(int[][] tablaDP, int[] costos, int presupuesto) {
        List<Integer> proyectosElegidos = new ArrayList<>();
        int proyecto = costos.length;
        int capacidad = presupuesto;

        while (proyecto > 0 && capacidad > 0) {
            if (tablaDP[proyecto][capacidad] != tablaDP[proyecto - 1][capacidad]) {
                proyectosElegidos.add(proyecto);
                capacidad -= costos[proyecto - 1];
            }
            proyecto--;
        }
        return proyectosElegidos;
    }

    public static void calcularMaxBeneficio(int[] costos, int[] beneficios, int presupuesto) {
        int[][] tablaDP = construirMatrizDP(costos, beneficios, presupuesto);
        List<Integer> proyectosSeleccionados = obtenerProyectosSeleccionados(tablaDP, costos, presupuesto);
        int beneficioMaximo = tablaDP[costos.length][presupuesto];

        System.out.print("Beneficio máximo alcanzado: " + beneficioMaximo + ". Proyectos seleccionados:");
        for (Integer proyecto : proyectosSeleccionados) {
            System.out.print(" " + proyecto);
        }
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;
        calcularMaxBeneficio(costos, beneficios, presupuesto);
    }
}
