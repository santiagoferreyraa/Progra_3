package Ejercicios.Clase8.Actividad2;

public class FloydWarshall {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = {
                {0, 8, 5},
                {3, 0, INF},
                {INF, 2, 0}
        };
        int V = graph.length;
        fw.floydWarshall(graph, V, 0);
    }

    void floydWarshall(int graph[][], int V, int centro) {
        int dist[][] = new int[V][V];
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V, centro);
    }

    void printSolution(int dist[][], int V, int centro) {
        System.out.print("La distancia del centro de distribución " + centro + "\n");
        for (int i = 1; i < V; i++) {
            System.out.print("--> " +  i + " : " + dist[centro][i]+ "\n");
        }
    }
}
