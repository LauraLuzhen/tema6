package boletin1.ej4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {
		
		String nombre;
		int edad;
		
		Scanner reader = new Scanner(System.in);
		
		try (BufferedWriter in = new BufferedWriter(new FileWriter("src\\boletin1\\ej4\\Datos.txt"))) {
			
		}
		
		reader.close();
	}
}
