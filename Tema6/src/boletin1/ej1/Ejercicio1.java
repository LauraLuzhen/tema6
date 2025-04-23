package boletin1.ej1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args){
		
		double media;
		int cont = 0;
		double suma = 0;
		double numero;
		
		try (Scanner reader = new Scanner(new FileReader("src\\boletin1\\ej1\\NumerosReales.txt"))) {
			
			while(reader.hasNextDouble()) {
				numero = reader.nextDouble();
				suma += numero;
				cont++;
			}
			
			media = suma / cont;
			
			System.out.println("Suma: " + suma);
			System.out.println("Media: " + media);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
