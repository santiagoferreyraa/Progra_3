package Ejercicios.source.Clase2.Actividad2;

public class MultiplicacionDeMatrices {
    public static void main(String[] args) {
        int[][] matriz1 = {{1,2},{4,7}};
        int[][] matriz2 = {{3,6},{9,2}};

        int[][] resultado = new int[matriz1.length][matriz2[0].length];

        for (int i = 0; i < matriz1.length; i++) {                  // 1 + n + 1 + 2n = 3n + 2
            for (int j = 0; j < matriz2[0].length; j++) {           // 3n + 2
                for (int k = 0; k < matriz1[0].length; k++) {           // 1 + n + 1 + 2n = 3n + 2
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];   // 3n
                }
            }
        }

        System.out.println("Resultado de la multiplicación:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}


/*
 * f(n) = 3n + 2 + n(3n + 2 + n(3n + 2 + 3n)) = 6n^3 + 5n^2 + 5n + 2
 * 
 * 6n^3 + 5n^2 + 5n + 2 <= c.n^3
 * 6 + 5/n + 5/n^2 + 2/n^3 <= c            <= Al haber dividido por n^3
 * n = 1
 * 6 + 5 + 5 + 2 <= c
 * c = 18
 * 
 * f(n) = 6n^3 + 5n^2 + 5n + 2 pertenece a O(n^3) para c = 18 y n = 1
 */