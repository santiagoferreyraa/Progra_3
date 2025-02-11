//Aplicar la técnica de Divide y Vencerás en una lista de clientes con id, nombre y
//scoring, buscando el cliente con el scoring máximo.
//Resolver mediante pseudocódigo
//Implementar en java
package main;

import models.Cliente;
import scoring.MaxScoringCliente;

public class Main {
    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Juan", 85),
            new Cliente(2, "Maria", 90),
            new Cliente(3, "Carlos", 78),
            new Cliente(4, "Ana", 95),
            new Cliente(5, "Luis", 88)
        };

        Cliente maxCliente = MaxScoringCliente.encontrarMaximo(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con el scoring máximo: " + maxCliente);
    }
}

