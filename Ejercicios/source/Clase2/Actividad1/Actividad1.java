package Ejercicios.Clase2.Actividad1;

public class Actividad1 {
    public static void main(String[] args) {
        int[][] mat = {{4,5,6},{7,8,9},{5,6,7}}; // O(1)

        int cont = 0; // O(1)
        int suma = 0; // O(1)

        for (int i = 0; i < mat.length; i++) { // O(1 + n + 2n) = O(1 + 3n)
            for (int j = 0; j < mat[0].length; j++) { // O(n + n^2 + 2n^2) = O(n + 3n^2)
                suma += mat[i][j]; // O(2n^2)
                cont++; // O(2n^2)
            }
        }

        int resultado = suma / cont; // O(2)

        System.out.println(resultado); // O(1)
    }
}

// 1 + 1 + 1 + 1 + 3n + n + 3n^2 + 2n^2 + 2n^2 + 2 + 1 = 7 + 4n + 7n^2 <= c.n
//                                                        7/n + 4 + 7n <= c
//                                                                  n0 == 1
//                                                           7 + 4 + 7 <= c
//                                                                  18 <= c
// f(n) = 7 + 4n + 7n^2 pertenece a O(n^2) para c = 18 y n0 = 1.
