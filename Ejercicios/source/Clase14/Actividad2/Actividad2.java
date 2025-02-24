package Ejercicios.source.Clase14.Actividad2;

public class Actividad2 {
    public static boolean esValido(int[][] tablero, int fila, int columna, int num) {
        for (int i = 0; i < 6; i++) {
            if (tablero[fila][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (tablero[i][columna] == num) {
                return false;
            }
        }

        int bloqueFila = (fila / 2) * 2;
        int bloqueColumna = (columna / 3) * 3;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[bloqueFila + i][bloqueColumna + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (tablero[fila][columna] == 0) {
                    for (int num = 1; num <= 6; num++) {
                        if (esValido(tablero, fila, columna, num)) {
                            tablero[fila][columna] = num;

                            if (resolverSudoku(tablero)) {
                                return true;
                            }

                            tablero[fila][columna] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tablero = {
                {0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 6},
                {0, 6, 0, 4, 0, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 0},
                {0, 4, 6, 0, 3, 5}
        };

        if (resolverSudoku(tablero)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No se puede resolver el Sudoku");
        }
    }
}
