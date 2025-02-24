package graph;

import java.util.*;

import models.Usuario;

public class Grafo {
    private Map<Integer, Usuario> usuarios;
    private Map<Integer, List<Integer>> grafo;

    public Grafo() {
        this.usuarios = new HashMap<>();
        this.grafo = new HashMap<>();
    }

    public void agregarUsuario(int id, String nombre) {
        Usuario usuario = new Usuario(id, nombre);
        usuarios.put(id, usuario);
        grafo.putIfAbsent(id, new ArrayList<>());
    }

    // Método para conectar dos usuarios (amistad bidireccional)
    public void agregarAmistad(int id1, int id2) {
        grafo.putIfAbsent(id1, new ArrayList<>());
        grafo.putIfAbsent(id2, new ArrayList<>());
        grafo.get(id1).add(id2);
        grafo.get(id2).add(id1);  // Relación bidireccional
    }

    public void DFS(int idInicio) {
        Set<Integer> visitado = new HashSet<>();
        DFSRecursivo(idInicio, visitado);
    }

    private void DFSRecursivo(int id, Set<Integer> visitado) {
        visitado.add(id);
        System.out.println("Visitando usuario: " + usuarios.get(id));

        for (int amigoId : grafo.getOrDefault(id, Collections.emptyList())) {
            if (!visitado.contains(amigoId)) {
                DFSRecursivo(amigoId, visitado);
            }
        }
    }

    public void BFS(int idInicio) {
        Queue<Integer> cola = new LinkedList<>();
        Set<Integer> visitado = new HashSet<>();

        cola.add(idInicio);
        visitado.add(idInicio);

        while (!cola.isEmpty()) {
            int id = cola.poll();
            System.out.println("Visitando usuario: " + usuarios.get(id));

            for (int amigoId : grafo.getOrDefault(id, Collections.emptyList())) {
                if (!visitado.contains(amigoId)) {
                    visitado.add(amigoId);
                    cola.add(amigoId);
                }
            }
        }
    }
}
