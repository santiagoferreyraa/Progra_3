package Ejercicios.Clase4.Actividad1;

import java.util.Arrays;

public class Actividad1 {
    public static Cliente ScoringMaximo(Cliente[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            return null;
        }

        if (arreglo.length == 1) {
            return arreglo[0];
        }

        int mitad = arreglo.length / 2;
        Cliente izq = ScoringMaximo(Arrays.copyOfRange(arreglo, 0, mitad));
        Cliente der = ScoringMaximo(Arrays.copyOfRange(arreglo, mitad, arreglo.length));

        return (izq.getScoring() >= der.getScoring()) ? izq : der;
    }

    public static void main(String[] args) {
        Cliente[] arreglo = new Cliente[3];

        Cliente cliente1 = new Cliente("Juan", 1, 2353465);
        Cliente cliente2 = new Cliente("Juli", 2, 4365645);
        Cliente cliente3 = new Cliente("Santi", 3, 1);

        arreglo[0] = cliente1;
        arreglo[1] = cliente2;
        arreglo[2] = cliente3;

        System.out.println(ScoringMaximo(arreglo));
    }
}
