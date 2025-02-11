package Ejercicios.Clase4.Actividad2;

import Ejercicios.Clase3.Actividad4.MergeSort;

import java.util.Arrays;

public class Actividad2 {
    public static int[] Juntar(int[] arreglo1, int[] arreglo2) {
        int[] juntar = new int[arreglo1.length + arreglo2.length];

        for (int i = 0; i < arreglo1.length; i++) {
            juntar[i] = arreglo1[i];
        }

        for (int i = 0; i < arreglo2.length; i++) {
            juntar[i + arreglo1.length] = arreglo2[i];
        }

        MergeSort.mergeSort(juntar);
        int[] resultado = Arrays.copyOfRange(juntar, juntar.length - 2, juntar.length);

        return resultado;
    }

    public static int[] DosMayores(int[] arreglo) {
        if (arreglo.length <= 2) {
            return arreglo;
        }

        int mitad = arreglo.length / 2;
        int[] izq = DosMayores(Arrays.copyOfRange(arreglo, 0, mitad));
        int[] der = DosMayores(Arrays.copyOfRange(arreglo, mitad, arreglo.length));

        int[] resultado = Juntar(izq, der);

        return resultado;

    }

    public static void main(String[] args) {
        int[] arreglo = {4,5,8,2,9,5,3,2};

        int[] resultado = DosMayores(arreglo);

        for (int i = 0; i < resultado.length; i++) {
            System.out.println(resultado[i]);
        }
    }
}
