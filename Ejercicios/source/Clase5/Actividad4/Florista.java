package Ejercicios.source.Clase5.Actividad4;
import java.util.*;

public class Florista { 
    public static int minimoCoste(int k, int[] c) {
        Arrays.sort(c); 
        int n = c.length;
        int costeTotal = 0;
        int comprasPrevias = 0; 
        for (int i = n - 1; i >= 0; i--) {
            costeTotal += (comprasPrevias / k + 1) * c[i];
            comprasPrevias++;
        }
        return costeTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        int resultado = minimoCoste(k, c);
        System.out.println(resultado);
        scanner.close();
    }
}

