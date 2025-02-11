//Una empresa de logística tiene varios centros de distribución en diferentes ciudades de
//una región y necesita optimizar las rutas de entrega de sus camiones. Cada centro de
//distribución está conectado a otros centros mediante carreteras, y cada carretera tiene
//un tiempo de viaje asociado en minutos. Además, algunos centros pueden tener costos
//adicionales asociados que pueden resultar en tiempos negativos en algunas rutas
//debido a descuentos especiales o condiciones excepcionales. La empresa desea no
//solo minimizar el tiempo total de entrega desde su centro de distribución principal hasta
//todas las otras ciudades, sino también identificar si existen ciclos negativos que podrían
//llevar a oportunidades de ahorro infinito en el sistema de rutas.
//Objetivo:
//Aplicar el algoritmo de Floyd-Warshall para: Encontrar el tiempo mínimo de entrega
//desde el centro de distribución principal hasta todos los demás centros de distribución,
//considerando las diferentes rutas disponibles.
package main;

public class FloydWarshall {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        //Usar este grafo para probar que se puede identificar que existen ciclos negativos 
        /**
        int graph[][] = { 
        	    {0, 1, INF},
        	    {INF, 0, -1},
        	    {-1, INF, 0}
        	};
        **/

        int graph[][] = { 
                			{0, 2, INF, 5},
                			{INF, 0, INF, 4},
                			{INF, INF, 0, INF},
                			{INF, INF, 2, 0}
            			};
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias más cortas
        printSolution(dist, V);

        // Verificar ciclos negativos
        if (hasNegativeCycle(dist, V)) {
            System.out.println("¡Se ha detectado un ciclo negativo en el grafo!");
        }
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Rutas más cortas entre todos los centros de distribución:");
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

    boolean hasNegativeCycle(int dist[][], int V) {
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                return true;
            }
        }
        return false;
    }
}
