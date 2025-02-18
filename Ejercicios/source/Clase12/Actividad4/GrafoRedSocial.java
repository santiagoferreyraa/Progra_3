package Ejercicios.source.Clase12.Actividad4;

import java.util.*;

public class GrafoRedSocial {
    private Map<Usuario, List<Usuario>> redSocial;

    public GrafoRedSocial() {
        this.redSocial = new HashMap<>();
    }

    public void agregarUsuarios(Usuario usuario) {
        redSocial.putIfAbsent(usuario, new ArrayList<>());
    }

    public void conectarUsuarios(Usuario origen, Usuario destino) {
        if (redSocial.containsKey(origen) && redSocial.containsKey(destino)) {
            redSocial.get(origen).add(destino);
            redSocial.get(destino).add(origen);
        }
    }

    public void BFS(Usuario usuarioInicial) {
        Queue<Usuario> cola = new LinkedList<>();
        Set<Usuario> visitado = new HashSet<>();

        System.out.println("Conexiones de amistad:");

        cola.add(usuarioInicial);
        visitado.add(usuarioInicial);

        while (!cola.isEmpty()) {
            Usuario usuario = cola.poll();
            System.out.println(usuario);

            for (Usuario vecino : redSocial.getOrDefault(usuario, Collections.emptyList())) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }

    public void DFS(Usuario usuarioInicial) {
        Set<Usuario> visitado = new HashSet<>();
        System.out.println("Usuarios alcanzables:");
        DFSRecursivo(usuarioInicial, visitado);
    }

    private void DFSRecursivo(Usuario usuario, Set<Usuario> visitado) {
        visitado.add(usuario);
        System.out.println(usuario);

        for (Usuario vecino : redSocial.getOrDefault(usuario, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                DFSRecursivo(vecino, visitado);
            }
        }
    }
}