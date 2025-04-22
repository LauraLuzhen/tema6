package boletin1.ej3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		
		double mediaEdad;
		double mediaAltura;
		double altura;
		int edad;
		String nombre;
		int sumaEdad = 0;
		double sumaAltura = 0;
		String nombres = "";
		int cont = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\ej3\\Alumnos.txt"))) {
			
			String linea = br.readLine();
			
			while (linea != null) {
				String datos[] = linea.split(" ");
				nombre = datos[0];
				edad = Integer.parseInt(datos[1]);
				altura = Double.parseDouble(datos[2]);
				
				nombres += nombre + " ";
				sumaEdad += edad;
				sumaAltura += altura;
				
				cont++;
				linea = br.readLine();
			}
			//Hola
			mediaAltura = sumaAltura / cont;
			mediaEdad = sumaEdad / cont;
			
			System.out.println(nombres);
			System.out.println("Media edad: " + mediaEdad);
			System.out.println("Media altura: " + mediaAltura);
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		
	}
}
