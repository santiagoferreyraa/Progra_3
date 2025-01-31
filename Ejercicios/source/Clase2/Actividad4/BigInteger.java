package Ejercicios.source.Clase2.Actividad4;
import java.math.*;

public class BigInteger {
    public static BigInteger factorial(int n) {
        if (n < 0) return null;

        BigInteger f = new BigInteger();
        for (int i = n; i > 0; i--)
            f = f.multiply(BigInteger.valueOf(i));     //   TODO: Arreglar implementacion con BigInteger
        return f;
        
    }

    public static void main(String[] args) {
        BigInteger fact = factorial(5);         // Con BigInteger podemos usar numeros mas grandes para el metodo factorial
        System.out.println("El factorial de 5 es: " + fact);
    }
}
