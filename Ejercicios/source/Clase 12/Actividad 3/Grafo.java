package graph;

import java.util.*;
import models.Almacen;

public class Grafo {
    private Map<Integer, Almacen> almacenes;
    private Map<Integer, List<Integer>> grafo;

    public Grafo() {
        this.almacenes = new HashMap<>();
        this.grafo = new HashMap<>();
    }

    public void agregarAlmacen(int id, String nombre) {
        Almacen almacen = new Almacen(id, nombre);
        almacenes.put(id, almacen);
        grafo.putIfAbsent(id, new ArrayList<>());
    }

    public void agregarRuta(int origen, int destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen); // Asegura que sea un grafo no dirigido
    }

    public void DFS(int nodoInicial) {
        Set<Integer> visitado = new HashSet<>();
        DFSRecursivo(nodoInicial, visitado);
    }

    private void DFSRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo);
        System.out.println("Visitando almacén: " + almacenes.get(nodo));

        for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                DFSRecursivo(vecino, visitado);
            }
        }
    }

    public void BFS(int nodoInicial) {
        Queue<Integer> cola = new LinkedList<>();
        Set<Integer> visitado = new HashSet<>();
        
        cola.add(nodoInicial);
        visitado.add(nodoInicial);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.println("Visitando almacén: " + almacenes.get(nodo));

            for (int vecino : grafo.getOrDefault(nodo, Collections.emptyList())) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}
