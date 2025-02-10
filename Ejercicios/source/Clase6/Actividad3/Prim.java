package Ejercicios.source.Clase6.Actividad3;

import java.util.*;

public class Prim {
    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int numVertices, List<List<int[]>> graph) {
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];
        boolean[] inMST = new boolean[numVertices];

        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(numVertices, key, inMST);  
            inMST[u] = true;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                }
            }
        }

        printMST(parent, numVertices, graph);
    }

    private static int minKey(int numVertices, int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printMST(int[] parent, int numVertices, List<List<int[]>> graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < numVertices; i++) {
            for (int[] neighbor : graph.get(i)) {
                if (neighbor[0] == parent[i]) {
                    System.out.println(parent[i] + " - " + i + "\t" + neighbor[1]);
                }
            }
        }
    }
}