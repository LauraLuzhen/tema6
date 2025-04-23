package boletin1.ej5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		String nombre;
		int edad;
		String dato = "";
		
		Scanner reader = new Scanner(System.in);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tema6\\src\\boletin1\\ej5\\Datos.txt", true))) {
		
			System.out.println("Introduce el nombre: ");
			nombre = reader.nextLine();
			System.out.println("Introduce la edad: ");
			edad = reader.nextInt();
			reader.nextLine();
			
			while (!nombre.equalsIgnoreCase("fin")) {
				dato = "Nombre: " + nombre + ", Edad: " + edad;
				bw.write(dato);
				bw.newLine();
				
				System.out.println("Introduce el nombre: ");
				nombre = reader.nextLine();
				System.out.println("Introduce la edad: ");
				edad = reader.nextInt();
				reader.nextLine();
			}
			
			bw.flush();
			bw.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
