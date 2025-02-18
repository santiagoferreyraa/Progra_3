package Ejercicios.source.Clase12.Actividad3;

import java.util.*;

public class GrafoAlmacenes {
    private Map<Almacen, List<Almacen>> redAlmacenes;

    public GrafoAlmacenes() {
        this.redAlmacenes = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        redAlmacenes.putIfAbsent(almacen, new ArrayList<>());
    }

    public void conectarAlmacenes(Almacen origen, Almacen destino) {
        if (redAlmacenes.containsKey(origen) && redAlmacenes.containsKey(destino)) {
            redAlmacenes.get(origen).add(destino);
            redAlmacenes.get(destino).add(origen);
        }
    }

    public void BFS(Almacen almacenInicial) {
        Queue<Almacen> cola = new LinkedList<>();
        Set<Almacen> visitado = new HashSet<>();

        cola.add(almacenInicial);
        visitado.add(almacenInicial);

        while (!cola.isEmpty()) {
            Almacen almacen = cola.poll();
            System.out.println("Visitando almacen: " + almacen);

            for (Almacen vecino : redAlmacenes.getOrDefault(almacen, Collections.emptyList())) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }

    public void DFS(Almacen almacenInicial) {
        Set<Almacen> visitado = new HashSet<>();
        DFSRecursivo(almacenInicial, visitado);
    }

    private void DFSRecursivo(Almacen almacen, Set<Almacen> visitado) {
        visitado.add(almacen);
        System.out.println("Visitando nodo: " + almacen);

        for (Almacen vecino : redAlmacenes.getOrDefault(almacen, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                DFSRecursivo(vecino, visitado);
            }
        }
    }
}
