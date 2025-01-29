package Actividad3;
import java.util.Scanner;

public class Actividad3 {
    public static int[] SolicitarNumeros() {
        Scanner scanner = new Scanner(System.in);

        int numeros[] = new int[2];

        System.out.print("Ingrese un número: ");
        int n1 = scanner.nextInt();
        numeros[0] = n1;

        System.out.print("Ingrese otro número: ");
        int n2 = scanner.nextInt();
        numeros[1] = n2;

        scanner.close();

        return numeros;
    }

    public static int OperacionMatematica(int[] numeros) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. Suma\n2. Resta\n3. Multiplicación\n4. División\nSeleccione una opción: ");

        int operacion = scanner.nextInt();
        int resultado = 0;

        switch (operacion) {
            case 1:
                resultado = numeros[0] + numeros[1];
                break;

            case 2:
                resultado = numeros[0] - numeros[1];
                break;

            case 3:
                resultado = numeros[0] * numeros[1];
                break;

            case 4:
                if (numeros[1] != 0) {
                    resultado = numeros[0] / numeros[1];

                } else {
                    System.out.println("No se puede dividir por 0.");
                }

                break;

            default:
                System.out.println("Operación no válida.");
                break;
        }

        scanner.close();

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("El resultado es " + OperacionMatematica(SolicitarNumeros()));
    }
}
