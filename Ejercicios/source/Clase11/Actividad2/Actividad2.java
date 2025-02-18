package Ejercicios.source.Clase11.Actividad2;

public class Actividad2 {
    private static void CombinacionesPosibles(int[][] tablero) {
        CombinacionesPosibles(tablero, 0);
    }

    private static void CombinacionesPosibles(int[][] tablero, int fila) {
        if (fila >= 4) {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            return;
        }

        for (int columna = 0; columna < 4; columna++) {
            if (esPosible(tablero, fila, columna)) {
                tablero[fila][columna] = 1;
                CombinacionesPosibles(tablero, fila + 1);
                tablero[fila][columna] = 0;
            }
        }
    }

    private static boolean esPosible(int[][] tablero, int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (tablero[fila][i] == 1 || tablero[i][columna] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] tablero = new int[4][4];
        CombinacionesPosibles(tablero);
    }
}
