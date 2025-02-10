package Ejercicios.source.Clase8.Actividad3;

public class FloydWarshallRecuperacionCaminos {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito
    
    public static void main(String[] args) {
    	FloydWarshallRecuperacionCaminos fw = new FloydWarshallRecuperacionCaminos();
        int graph[][] = { 
                            {0, 8, 5},
                            {3, 0, INF},
                            {INF, 2, 0}
                        };

        int V = graph.length;
        fw.floydWarshall(graph, V);
        int origen = 1;
        int destino = 2;
        System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
        fw.imprimirCamino(origen, destino);
    }

    int[][] distancia;
    int[][] camino; 


    void floydWarshall(int grafo[][], int V) {
        distancia = new int[V][V];
        camino = new int[V][V]; 

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                distancia[i][j] = grafo[i][j];
                if (i != j && grafo[i][j] != INF) {
                    camino[i][j] = i; 
                } else {
                    camino[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (distancia[i][k] != INF && distancia[k][j] != INF && distancia[i][k] + distancia[k][j] < distancia[i][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                        camino[i][j] = camino[k][j];
                    }
                }
            }
        }
        printSolution(distancia, V);
    }


    void imprimirCamino(int origen, int destino) {
        if (camino[origen][destino] == -1) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
            return;
        }
        imprimirCaminoRecursivo(origen, destino);
        System.out.println(destino);
    }


    void imprimirCaminoRecursivo(int origen, int destino) {
        if (camino[origen][destino] == origen) {
            System.out.print(origen + " -> ");
            return;
        }
        imprimirCaminoRecursivo(origen, camino[origen][destino]);
        System.out.print(camino[origen][destino] + " -> ");
    }


    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
