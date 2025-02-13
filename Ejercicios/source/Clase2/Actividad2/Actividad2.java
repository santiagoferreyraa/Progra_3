package Ejercicios.source.Clase2.Actividad2;

public class Actividad2 {
    public static void ImprimirMatriz(int[][] mat) {
        for (int i = 0; i < mat.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            for (int j = 0; j < mat.length; j++) { // O(n + n^2 + 2n^2) = O(n + 3n^2)
                System.out.print(mat[i][j] + " "); // O(2n^2)
            }
            System.out.println(); // O(n)
        }
        // 1 + 3n + n + 3n^2 + 2n^2 + n = 1 + 5n + 5n^2 <= c.n
        //                                 1/n + 5 + 5n <= c
        //                                           n0 == 1
        //                                    1 + 5 + 5 <= c
        //                                           11 <= c
        // f(n) = 1 + 5n + 5n^2 pertenece a O(n^2) para c = 11 y n0 = 1.
    }

    public static void main(String[] args) {
        int[][] mat = {{4,5},{7,8}}; // O(1)
        int[][] mat2 = {{4,5},{7,8}}; // O(1)
        int[][] resultado = new int[mat.length][mat.length]; // O(1)

        for (int i = 0; i < mat.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            for (int j = 0; j < mat.length; j++) { // O(n + n^2 + 2n^2) = O(n + 3n^2)
                for (int k = 0; k < mat.length; k++) { // O(n^2 + n^3 + 2n^3) = O(n^2 + 3n^3)
                    resultado[i][j] += mat[i][k] * mat2[k][j]; // O(3n^3)
                }
            }
        }

        ImprimirMatriz(resultado); // O(n^2)

        // 1 + 1 + 1 + 1 + 3n + n + 3n^2 + n^2 + 3n^3 + 3n^3 + n^2 = 4 + 4n + 5n^2 + 6n^3 <= c.n
        //                                                            4/n + 4 + 5n + 6n^2 <= c
        //                                                                             n0 == 1
        //                                                                  4 + 4 + 5 + 6 <= c
        //                                                                             19 <= c
        // f(n) = 4 + 4n + 5n^2 + 6n^3 pertenece a O(n^3) para c = 19 y n0 = 1.
    }
}
