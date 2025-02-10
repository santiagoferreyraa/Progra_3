package main;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese un número entero: ");
		int numero = scanner.nextInt();
		String x = "";
		for(int i = 1; i <= numero; i++) {
			if(i % 2 == 0) {
				x = "PAR";
			}
			else {
				x = "IMPAR";
			}
			System.out.println(i + " " + x);
		}
	}

}
