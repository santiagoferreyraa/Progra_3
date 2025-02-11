package main;

import java.util.Scanner;

public class FloydWarshallOrigenDestino {
    final static int INF = 99999;  

    public static void main(String[] args) {
    	FloydWarshallOrigenDestino fw = new FloydWarshallOrigenDestino();
        int graph[][] = {
                {0, 8, 5},
                {3, 0, INF},
                {INF, 2, 0}
        };
        int V = graph.length;
        fw.floydWarshall(graph, V);

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el vértice de origen (0 a " + (V-1) + "): ");
        int origen = sc.nextInt();
        System.out.print("Ingrese el vértice de destino (0 a " + (V-1) + "): ");
        int destino = sc.nextInt();

        if (fw.dist[origen][destino] == INF) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
        } else {
            System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
            fw.imprimirCamino(origen, destino);
            System.out.println("\nDistancia mínima: " + fw.dist[origen][destino]);
        }
        
        sc.close();
    }

    int[][] dist;
    int[][] P;

    void floydWarshall(int graph[][], int V) {
        dist = new int[V][V];
        P = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = i;  
                } else {
                    P[i][j] = -1;  
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        P[i][j] = P[i][k]; // CORRECCIÓN
                    }
                }
            }
        }

        printSolution(dist, V);
    }

    void imprimirCamino(int origen, int destino) {
        if (P[origen][destino] == -1) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
            return;
        }
        System.out.print(origen + " -> ");
        reconstruirCamino(origen, destino);
        System.out.println(destino);
    }

    void reconstruirCamino(int origen, int destino) {
        if (origen == destino || P[origen][destino] == -1) {
            return;
        }
        reconstruirCamino(origen, P[origen][destino]);
        System.out.print(P[origen][destino] + " -> ");
    }

    void printSolution(int dist[][], int V) {
        System.out.println("\nMatriz de distancias más cortas:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
