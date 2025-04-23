package boletin1.ej2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		double media;
		int cont = 0;
		int suma = 0;
		int numero;
		
		try (Scanner reader = new Scanner(new FileReader("src\\boletin1\\ej2\\Enteros.txt"))) {

			while (reader.hasNextInt()) {
				numero = reader.nextInt();
				suma += numero;
				cont++;
			}
			
			media = suma / cont;
			System.out.println("Suma: " + suma);
			System.out.println("Media: " + media);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
