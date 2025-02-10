package Ejercicios.source.Clase6.Actividad3;
import java.util.*;

public class DistribucionElectrica {
    private int estaciones;
    private static final int INF = 999;
    private List<List<int[]>> grafo;

    public DistribucionElectrica(int Estaciones) {
        this.estaciones = Estaciones;
        this.grafo = new ArrayList<>();
        for (int i = 0; i < Estaciones; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void agregar(int estacion1, int estacion2, int costo) {
        grafo.get(estacion1).add(new int[]{estacion2, costo});
        grafo.get(estacion2).add(new int[]{estacion1, costo});
    }

    private int minKey(int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < estaciones; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    
    public int[] calcularMST() {
        int[] key = new int[estaciones];
        int[] parent = new int[estaciones];
        boolean[] inMST = new boolean[estaciones];

        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < estaciones - 1; count++) {
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
        return parent;
    }

    public static void main(String[] args) {
        DistribucionElectrica red = new DistribucionElectrica(5);
        red.agregar(0, 1, 1);
        red.agregar(0, 2, 4);
        red.agregar(2, 3, 2);
        red.agregar(3, 1, 5);
        red.agregar(1, 4, 3);

        int costoTotal = 0;
        int[] resultado = red.calcularMST();
        System.out.println("Conexiones en el MST:");
        for (int i = 1; i < resultado.length; i++) {
            int origen = resultado[i];
            int destino = i;
            int costo = 0;

            for (int[] vecino : red.grafo.get(origen)) {
                if (vecino[0] == destino) {
                    costo = vecino[1];
                    break;
                }
            }
            System.out.println("Estacion " + origen + " - Estacion " + destino + " (Costo: " + costo + ")");
            costoTotal += costo;
        }
        System.out.println();
        System.out.println("Costo total del MST: " + costoTotal);

    }
}