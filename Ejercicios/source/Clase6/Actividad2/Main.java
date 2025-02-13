package Ejercicios.source.Clase6.Actividad2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.InicializarGrafo(5);

        grafo.AgregarArista(1, 2);
        grafo.AgregarArista(1, 3);
        grafo.AgregarArista(3, 1);
        grafo.AgregarArista(2, 4);
        grafo.AgregarArista(4, 5);
        grafo.AgregarArista(5, 2);
        grafo.ImprimirGrafo();

        grafo.EliminarArista(1, 3);
        grafo.ImprimirGrafo();

        System.out.println(grafo.VerificarArista(1, 2));
        System.out.println(grafo.VerificarArista(1, 3));

        ArrayList<Integer> adyacentes = grafo.ListarAdyacentes(2);
        for (Integer i : adyacentes) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(grafo.ContarGradoEntrada(2));
        System.out.println(grafo.ContarGradoSalida(2));
    }
}
