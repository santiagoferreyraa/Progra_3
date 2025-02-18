package Ejercicios.source.Clase13.Actividad2;

import java.util.*;

class Node {
    String name;
    int cost;

    public Node(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class EmpresaViajes {
    private final Map<String, List<Node>> graph = new HashMap<>();

    // Agregar conexiones al grafo
    public void addEdge(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Node(to, cost));
    }

    private void printPath(Map<String, String> parentMap, String goal) {
        List<String> path = new ArrayList<>();
        String step = goal;

        while (step != null) {
            path.add(step);
            step = parentMap.get(step);
        }

        Collections.reverse(path);
        System.out.println("Camino a seguir: " + String.join(" -> ", path));
    }

    // Método para realizar la búsqueda UCS
    public int uniformCostSearch(String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<String, Integer> costMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();

        priorityQueue.add(new Node(start, 0));
        costMap.put(start, 0);
        parentMap.put(start, null);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.name.equals(goal)) {
                printPath(parentMap, goal);
                return current.cost;
            }

            // Explorar vecinos
            for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                int newCost = current.cost + neighbor.cost;

                if (!costMap.containsKey(neighbor.name) || newCost < costMap.get(neighbor.name)) {
                    costMap.put(neighbor.name, newCost);
                    parentMap.put(neighbor.name, current.name);
                    priorityQueue.add(new Node(neighbor.name, newCost));
                }
            }
        }

        return -1; // Retorna -1 si no se encuentra un camino
    }

    public static void main(String[] args) {
        EmpresaViajes empresaViajes = new EmpresaViajes();

        // Agregar conexiones
        empresaViajes.addEdge("Buenos Aires", "Río de Janeiro", 2);
        empresaViajes.addEdge("Buenos Aires", "Santiago de Chile", 4);
        empresaViajes.addEdge("Río de Janeiro", "Santiago de Chile", 1);
        empresaViajes.addEdge("Río de Janeiro", "Montevideo", 7);
        empresaViajes.addEdge("Santiago de Chile", "Ciudad de México", 3);
        empresaViajes.addEdge("Montevideo", "Ciudad de México", 1);

        // Ejecutar UCS
        String startRoom = "Buenos Aires";
        String goalRoom = "Ciudad de México";
        int totalCost = empresaViajes.uniformCostSearch(startRoom, goalRoom);

        if (totalCost != -1) {
            System.out.println("El costo mínimo desde " + startRoom + " hasta " + goalRoom + " es: " + totalCost);
        } else {
            System.out.println("No se encontró un camino desde " + startRoom + " hasta " + goalRoom);
        }
    }
}