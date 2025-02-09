package Ejercicios.Clase6.Actividad4;

import java.util.*;

public class Logistica {
    static class Ruta {
        int destino;
        int tiempo;

        Ruta(int destino, int tiempo) {
            this.destino = destino;
            this.tiempo = tiempo;
        }
    }

    static class Grafo {
        int centros;
        List<List<Ruta>> adyacencia;

        Grafo(int centros) {
            this.centros = centros;
            adyacencia = new ArrayList<>(centros);
            for (int i = 0; i < centros; i++) {
                adyacencia.add(new ArrayList<>());
            }
        }

        void agregarRuta(int origen, int destino, int tiempo) {
            adyacencia.get(origen).add(new Ruta(destino, tiempo));
            adyacencia.get(destino).add(new Ruta(origen, tiempo));
        }

        void dijkstra(int centroPrincipal) {
            int[] tiempos = new int[centros];
            Arrays.fill(tiempos, Integer.MAX_VALUE);
            tiempos[centroPrincipal] = 0;

            PriorityQueue<Ruta> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.tiempo));
            pq.add(new Ruta(centroPrincipal, 0));
            boolean[] visitado = new boolean[centros];

            while (!pq.isEmpty()) {
                int actual = pq.poll().destino;

                if (visitado[actual]) continue;
                visitado[actual] = true;

                for (Ruta ruta : adyacencia.get(actual)) {
                    int vecino = ruta.destino;
                    int tiempo = ruta.tiempo;

                    if (!visitado[vecino] && tiempos[actual] + tiempo < tiempos[vecino]) {
                        tiempos[vecino] = tiempos[actual] + tiempo;
                        pq.add(new Ruta(vecino, tiempos[vecino]));
                    }
                }
            }
            imprimirResultados(tiempos, centroPrincipal);
        }

        void imprimirResultados(int[] tiempos, int centroPrincipal) {
            System.out.println("Tiempos mínimos de entrega desde el centro " + centroPrincipal + ":");
            for (int i = 0; i < tiempos.length; i++) {
                System.out.println("Hasta " + i + " es " + tiempos[i] + " minutos");
            }
        }
    }

    public static void main(String[] args) {
        int centros = 6;
        Grafo grafo = new Grafo(centros);

        grafo.agregarRuta(0, 1, 4);
        grafo.agregarRuta(0, 2, 1);
        grafo.agregarRuta(2, 1, 2);
        grafo.agregarRuta(1, 3, 1);
        grafo.agregarRuta(2, 3, 5);
        grafo.agregarRuta(3, 4, 3);
        grafo.agregarRuta(4, 5, 1);
        grafo.agregarRuta(3, 5, 2);

        grafo.dijkstra(0);
    }
}
