package Ejercicios.source.Clase6.Actividad2;

import java.util.ArrayList;

public class Grafo {
    private int grafo[][];

    public void InicializarGrafo(int cantVertices) {
        grafo = new int[cantVertices][cantVertices];
    }

    public void AgregarArista(int vertice1, int vertice2) {
        grafo[vertice1 - 1][vertice2 - 1] = 1;
    }

    public void EliminarArista(int vertice1, int vertice2) {
        grafo[vertice1 - 1][vertice2 - 1] = 0;
    }

    public boolean VerificarArista(int vertice1, int vertice2) {
        return grafo[vertice1 - 1][vertice2 - 1] == 1;
    }

    public ArrayList<Integer> ListarAdyacentes(int vertice) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < grafo.length; i++) {
            if (grafo[vertice - 1][i] == 1) {
                adyacentes.add(i);
            }
        }

        return adyacentes;
    }

    public int ContarGradoEntrada(int vertice) {
        int cont = 0;
        for (int i = 0; i < grafo.length; i++) {
            if (grafo[i][vertice - 1] == 1) {
                cont++;
            }
        }

        return cont;
    }

    public int ContarGradoSalida(int vertice) {
        int cont = 0;
        for (int i = 0; i < grafo.length; i++) {
            if (grafo[vertice - 1][i] == 1) {
                cont++;
            }
        }

        return cont;
    }

    public void ImprimirGrafo() {
        System.out.print("  ");
        for (int i = 1; i <= grafo.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < grafo.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < grafo[0].length; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}
