package Ejercicios.source.Clase8.Actividad2;

public class CentroDeDistribucion {
    final static int INF = 99999;
    public static void main(String[] args) {
        CentroDeDistribucion centros = new CentroDeDistribucion();
        int tiempoEntrega[][] = { 
                            {5, 11, 25},
                            {9, INF, INF},
                            {INF, 4, INF}
                        };
        int centroPrincipal = 1; 
        int V = tiempoEntrega.length;
        centros.algoritmoFloydWarshall(tiempoEntrega, V, centroPrincipal);
    }


    void algoritmoFloydWarshall(int tiempo[][], int V, int centro) {
        int[][] distancia = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                distancia[i][j] = tiempo[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (distancia[i][k] + distancia[k][j] < distancia[i][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                    }
                }
            }
        }

        printSolution(distancia, V, centro);
    }


    void printSolution(int distancia[][], int V, int centro) {
        System.out.println("Tiempo minimo de entrega desde el centro de distribucion " + (centro+1) + ":");
        for (int i = 0; i < V; i++) {
            if (i!= centro) {
                System.out.print("Al centro " + (i+1) + ": " + distancia[centro][i] + " minutos\n");
                if (distancia[centro][i] == INF) System.out.println("No hay ruta disponible.");
            }
        }
    }
}
