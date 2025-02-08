package Ejercicios.Clase2.Actividad4;

import java.math.BigInteger;

public class FactorialBigInteger {
    public static BigInteger factorial(int n) {
        if (n < 0) return null;

        BigInteger fact = BigInteger.ONE;
        for (int i = n; i > 0; i--)
            fact = fact.multiply(BigInteger.valueOf(i));
        return fact;

    }

    public static void main(String[] args) {

        BigInteger fact = factorial(50); // Con BigInteger podemos usar numeros mas grandes para el metodo factorial
        System.out.println("El factorial es: " + fact);
    }
}