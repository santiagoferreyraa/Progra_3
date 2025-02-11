package Ejercicios.source.Clase3.Actividad3;

// Codigo del repo de la clase

public class QuickSort {
    
    private static int particion(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto]; 
        int i = (bajo - 1); 

        for (int j = bajo; j < alto; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;

        return i + 1;
    }
    public static void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            int indiceParticion = particion(arreglo, bajo, alto);
            quickSort(arreglo, bajo, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, alto);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,42,54,7,1,1,2,8,135,125,9,63,12,0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Arreglo ordenado: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

