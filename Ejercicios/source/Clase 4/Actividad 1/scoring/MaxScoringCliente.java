package scoring;

import models.Cliente;

public class MaxScoringCliente {

    public static Cliente encontrarMaximo(Cliente[] lista, int inicio, int fin) {
        if (inicio == fin) {
            return lista[inicio];
        }

        int mitad = (inicio + fin) / 2;
        Cliente maxIzquierda = encontrarMaximo(lista, inicio, mitad);
        Cliente maxDerecha = encontrarMaximo(lista, mitad + 1, fin);

        return (maxIzquierda.getScoringCliente() > maxDerecha.getScoringCliente()) ? maxIzquierda : maxDerecha;
    }
}
