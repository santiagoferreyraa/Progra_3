package Ejercicios.source.Clase3.Actividad2;

public class BusquedaBinaria {
    public static int busquedaBinaria(int[] arr, int x){
        int ini = 0, fin = arr.length - 1;

        while (ini <= fin) {
            int mid = (ini + fin) / 2;
        
            if (arr[mid] == x) return mid;
            
            if (arr[mid] < x){
                ini = mid + 1;
            } else {
                fin = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,4,2,6,8,99,11,42,16,18};
        System.out.println(busquedaBinaria(array, 6)); 
    }
}
