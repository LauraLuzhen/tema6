package boletin2.ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		int contCaracteres = 0;
		int contLineas = 0;
		int contPalabras = 0;
		String cad = "";
		
		String[] palabras;
		
		final String FICHERO = "src\\boletin2\\ej1\\carta.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader (FICHERO))) {
			cad = br.readLine();
			
			while(cad != null) {
				palabras = cad.split(" ");
				contPalabras += palabras.length;
				
				for (String palabra: palabras) {
					contCaracteres += palabra.length();
				}
				
				cad = br.readLine();
				contLineas++;
			}
			
			System.out.println("Cantidad de caracteres: " + contCaracteres);
			System.out.println("Cantidad de palabras: " + contPalabras);
			System.out.println("Cantidad de líneas: " + contLineas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
