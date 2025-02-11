package Ejercicios.source.Clase3.Actividad4;

// Codigo sacado del repo de la clase 

public class MergeSort {
    
    private static void merge(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }
    
    
    public static void mergeSort(int[] arreglo) {
        if (arreglo.length < 2) {
            return; 
        }
        int medio = arreglo.length / 2;
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];

        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }
        mergeSort(izquierda);
        mergeSort(derecha);
        merge(arreglo, izquierda, derecha);
    }

    
    public static void main(String[] args) {
        int[] arr = {1,42,54,7,1,1,2,8,135,125,9,63,12,0};
        mergeSort(arr);
        System.out.println("Arreglo desordenado:");
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

}
