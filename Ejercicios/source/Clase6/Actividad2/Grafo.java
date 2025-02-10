package Ejercicios.source.Clase6.Actividad2;

import java.util.ArrayList;

public class Grafo {

    protected int graph[][];

    public void inicializarGrafo(int V) {
        graph = new int[V][V];
    }

    public void agregar(int v1, int v2) {
        graph[v1 - 1][v2 - 1] = 1;
    }

    public void eliminar(int v1, int v2) {
        graph[v1 - 1][v2 - 1] = 0;
    }

    public ArrayList<Integer> adyacentes(int vertice) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[vertice - 1][i] == 1) {
                arr.add(i);
            }
        }

        return arr;
    }

    public int gradoEntrada(int vertice) {
        int cont = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i][vertice - 1] == 1) {
                cont++;
            }
        }

        return cont;
    }

    public int gradoSalida(int vertice) {
        int cont = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertice - 1][i] == 1) {
                cont++;
            }
        }

        return cont;
    }

    public boolean verificar(int vertice1, int vertice2) {
        return graph[vertice1 - 1][vertice2 - 1] == 1;
    }

    
    public static void main(String[] args) {
        Grafo g = new Grafo();
        int v = 4;
        g.inicializarGrafo(v);
        g.agregar(1,3);
        g.agregar(2,3);
        g.agregar(1,2);
        g.agregar(2,4);
        g.agregar(1, 4);
        g.eliminar(1,3);

        System.out.println("Grafo: ");
        for (int i = 1; i <= v; i++) {
            System.out.println("Adyacentes de "+ i +": " + g.adyacentes(i));
            System.out.println("Grado entrada de "+ i +": " + g.gradoEntrada(i));
            System.out.println("Grado salida de "+ i +": " + g.gradoSalida(i));
            System.out.println();
        }
        System.out.println("Verificar si 1 y 3 están conectados: " + g.verificar(1, 3));

    }
}

