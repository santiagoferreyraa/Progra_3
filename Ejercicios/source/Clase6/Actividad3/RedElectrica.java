package Ejercicios.source.Clase6.Actividad3;

import java.util.*;

public class RedElectrica {
    private int numEstaciones;
    private List<List<int[]>> grafo;
    private static final int INF = Integer.MAX_VALUE;

    public RedElectrica(int numEstaciones) {
        this.numEstaciones = numEstaciones;
        this.grafo = new ArrayList<>();
        for (int i = 0; i < numEstaciones; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void agregarConexion(int estacion1, int estacion2, int costo) {
        grafo.get(estacion1).add(new int[]{estacion2, costo});
        grafo.get(estacion2).add(new int[]{estacion1, costo});
    }

    public void calcularMST() {
        int[] key = new int[numEstaciones];
        int[] parent = new int[numEstaciones];
        boolean[] inMST = new boolean[numEstaciones];

        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numEstaciones - 1; count++) {
            int u = minKey(key, inMST);
            inMST[u] = true;

            for (int[] vecino : grafo.get(u)) {
                int v = vecino[0];
                int peso = vecino[1];
                if (!inMST[v] && peso < key[v]) {
                    key[v] = peso;
                    parent[v] = u;
                }
            }
        }

        imprimirMST(parent);
    }

    private int minKey(int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < numEstaciones; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void imprimirMST(int[] parent) {
        int costoTotal = 0;
        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (int i = 1; i < numEstaciones; i++) {
            for (int[] vecino : grafo.get(i)) {
                if (vecino[0] == parent[i]) {
                    System.out.println(parent[i] + " - " + i + " \tCosto: " + vecino[1]);
                    costoTotal += vecino[1];
                }
            }
        }
        System.out.println("Costo Total de la Red: " + costoTotal);
    }

    public static void main(String[] args) {
        RedElectrica red = new RedElectrica(4);
        red.agregarConexion(0, 1, 1);
        red.agregarConexion(0, 2, 4);
        red.agregarConexion(1, 3, 3);
        red.agregarConexion(2, 3, 2);
        red.calcularMST();
    }
}
