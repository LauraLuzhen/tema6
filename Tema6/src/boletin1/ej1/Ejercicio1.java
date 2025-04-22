package boletin1.ej1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		
		double media;
		int cont = 0;
		double suma = 0;
		double numero;
		
		try (Scanner reader = new Scanner(new FileReader("src\\boletin1\\ej1\\NumerosReales.txt"))) {

			while (reader.hasNextDouble()) {
				numero = reader.nextDouble();
				suma += numero;
				cont++;
			}
			
			media = suma / cont;
			System.out.println("Suma total: " + suma);
			System.out.println("Media: " + media);
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero " + e.getMessage());
		}
	}
}
