package Ejercicios.source.Clase2.Actividad5;

public class SumaNPrimeros {
    public static int suma(int n){
        if (n == 0){
            return 0;
        }
        return n + suma(n - 1);
    }    

    public static void main(String[] args) {
        int n = 15;
        System.out.println("La suma de los primeros n numeros es: " + suma(n));
    }
}
