package main;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 25;
		System.out.println(factorial(n));
	}
	
	public static Object factorial(int n) {
		if(n <= 20) {
			return factorialLong(n);
		}
		else {
			return factorialBigInteger(n);
		}
	}
	
	public static long factorialLong(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialLong(n - 1);
    }
	
	public static BigInteger factorialBigInteger(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialBigInteger(n - 1));
    }

}
