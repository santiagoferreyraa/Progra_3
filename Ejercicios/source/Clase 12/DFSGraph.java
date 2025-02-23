package main;

import java.util.*;

public class DFSGraph {
    private Map<Integer, List<Integer>> grafo;

    public DFSGraph() {
        this.grafo = new HashMap<>();
    }

    public void agregarArista(int origen, int destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen); // Esto asegura que sea no dirigido
    }

    public void DFS(int nodoInicial) {
        Set<Integer> visitado = new HashSet<>();
        DFSRecursivo(nodoInicial, visitado);
    }

    private void DFSRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo);
        System.out.println("Visitando nodo: " + nodo);
        
        for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                DFSRecursivo(vecino, visitado);
            }
        }
    }

    public static void main(String[] args) {
        DFSGraph grafo = new DFSGraph();
        grafo.agregarArista(5, 2);
        grafo.agregarArista(2, 0);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);
        
        System.out.println("Recorrido DFS para un grafo no dirigido desde el nodo 0:");
        grafo.DFS(0);
    }
}