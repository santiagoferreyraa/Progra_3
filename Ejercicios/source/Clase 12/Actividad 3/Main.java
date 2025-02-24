package main;

import models.Almacen;
import graph.Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        redAlmacenes.agregarAlmacen(1, "Almacen A");
        redAlmacenes.agregarAlmacen(2, "Almacen B");
        redAlmacenes.agregarAlmacen(3, "Almacen C");
        redAlmacenes.agregarAlmacen(4, "Almacen D");
        redAlmacenes.agregarAlmacen(5, "Almacen E");

        redAlmacenes.agregarRuta(1, 2);
        redAlmacenes.agregarRuta(1, 3);
        redAlmacenes.agregarRuta(2, 4);
        redAlmacenes.agregarRuta(3, 5);
        redAlmacenes.agregarRuta(4, 5);

        System.out.println("Recorrido DFS desde el Almacén 1:");
        redAlmacenes.DFS(1);

        System.out.println();

        System.out.println("Recorrido BFS desde el Almacén 1:");
        redAlmacenes.BFS(1);
    }
}
