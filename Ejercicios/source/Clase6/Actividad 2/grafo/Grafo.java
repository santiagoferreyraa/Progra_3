package grafo;

import java.util.ArrayList;

public class Grafo {
    private int[][] matriz;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 1;
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 0;
        }
    }

    public boolean existeArista(int origen, int destino) {
        return matriz[origen][destino] == 1;
    }

    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Nodos adyacentes a " + vertice + ": ");
            ArrayList<Integer> adyacentes = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
            System.out.println(adyacentes.isEmpty() ? "Ninguno" : adyacentes);
        }
    }

    public int gradoSalida(int vertice) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matriz[vertice][i] == 1) {
                grado++;
            }
        }
        return grado;
    }

    public int gradoEntrada(int vertice) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matriz[i][vertice] == 1) {
                grado++;
            }
        }
        return grado;
    }

    public void mostrarMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}