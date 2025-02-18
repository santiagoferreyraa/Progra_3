package Ejercicios.source.Clase11.Actividad1;

public class Actividad1 {
    public static void main(String[] args) {
        int[][] tablero = new int[4][4];
        ColocarReina(tablero, 0, 0, 0);
    }

    private static void ColocarReina(int[][] tablero, int fila, int columna, int reinasColocadas) {
        if (reinasColocadas == 2) {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            return;
        }

        for (int i = fila; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == fila && j < columna) {
                    continue;
                }

                if (esValido(tablero, i, j)) {
                    tablero[i][j] = 1;
                    ColocarReina(tablero, i, j + 1, reinasColocadas + 1);
                    tablero[i][j] = 0;
                }
            }
        }
    }

    private static boolean esValido(int[][] tablero, int fila, int columna) {
        for (int i = 0; i < 4; i++) {
            if (tablero[fila][i] == 1 || tablero[i][columna] == 1) {
                return false;
            }
        }

        for (int i = -4; i < 4; i++) {
            if (Diagonales(fila + i, columna + i) && tablero[fila + i][columna + i] == 1) {
                return false;
            }

            if (Diagonales(fila + i, columna - i) && tablero[fila + i][columna - i] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean Diagonales(int fila, int columna) {
        return fila >= 0 && fila < 4 && columna >= 0 && columna < 4;
    }
}
