package Ejercicios.source.Clase2.Actividad4;

public class FactorialLong {
    public static long factorial(int n){
        if (n < 0) return -1;

        if (n == 0 || n == 1) return 1;

        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int n = 7;  // Long solo llega hasta 20 porque su limite es 2^63 - 1
        System.out.println("Factorial de " + n + " es: " + factorial(n));
    }
    
}
