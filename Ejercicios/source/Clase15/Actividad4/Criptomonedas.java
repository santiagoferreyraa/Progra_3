package Ejercicios.source.Clase15.Actividad4;

import java.util.*;

class Nodo implements Comparable<Nodo> {
    String nombre;
    int cobro;
    int pago;

    public Nodo(String nombre, int cobro, int pago) {
        this.nombre = nombre;
        this.cobro = cobro;
        this.pago = pago;
    }

    @Override
    public int compareTo(Nodo otro) {
        return Integer.compare(otro.cobro, this.cobro);
    }
}

public class Criptomonedas {
    public static void main(String[] args) {
        PriorityQueue<Nodo> nodos = new PriorityQueue<>();
        nodos.add(new Nodo("Nodo A", 50, -20));
        nodos.add(new Nodo("Nodo B", 30, -10));
        nodos.add(new Nodo("Nodo C", 20, -5));
        nodos.add(new Nodo("Nodo D", 40, -25));
        nodos.add(new Nodo("Nodo E", 10, -8));

        int saldoInicial = 20;
        double tasaCambio = 1.2;

        planificarRecorrido(nodos, saldoInicial, tasaCambio);
    }

    public static void planificarRecorrido(PriorityQueue<Nodo> nodos, int saldo, double tasaCambio) {
        double saldoFiat = saldo * tasaCambio;
        List<String> recorrido = new ArrayList<>();

        while (!nodos.isEmpty()) {
            Nodo actual = nodos.poll();

            if (saldo + actual.cobro >= Math.abs(actual.pago)) {
                saldo += actual.cobro + actual.pago;
                saldoFiat = saldo * tasaCambio;
                recorrido.add(actual.nombre);
            }
        }

        System.out.println("Recorrido óptimo: " + recorrido);
        System.out.println("Saldo final en criptos: " + saldo);
        System.out.println("Saldo final en dólares: $" + saldoFiat);
    }
}
