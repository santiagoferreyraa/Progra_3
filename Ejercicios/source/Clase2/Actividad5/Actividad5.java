package Ejercicios.Clase2.Actividad5;

public class Actividad5 {
    public static int SumarNumeros(int n) {
        return SumarNumeros(n, 0);
    }

    private static int SumarNumeros(int n, int suma) {
        if (n == 0) { // O(1)
            return suma; // O(1)

        } else {
            suma += n; // O(2)
            suma = SumarNumeros(n - 1, suma); // T(n - 1)
            return suma; // O(2)
        }
    }

    public static void main(String[] args) {
        System.out.println(SumarNumeros(8));
    }

// T(n) = (n - 1) + O(6)
// T(n) = n + 5
// T(n) = n + 5 pertenece a O(n) ya que es el mayor exponente de n.
}
