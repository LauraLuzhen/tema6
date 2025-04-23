package boletin1.ej3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args){
		
		String cad;
		String nombres = "";
		int sumaEdad = 0;
		int mediaEdad;
		double sumaEstatura = 0;
		double mediaEstatura;
		int cont = 0;

		String datos[];
		
		try (BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\ej3\\Alumnos.txt"))) {
			cad = br.readLine();
			
			do {
				datos = cad.split(" ");
				nombres += datos[0] + " ";
				sumaEdad += Integer.parseInt(datos[1]);
				sumaEstatura += Double.parseDouble(datos[2]);
				cont++;
				
				cad = br.readLine();
			} while (cad != null);
			
			mediaEdad = sumaEdad / cont;
			mediaEstatura = sumaEstatura / cont;
			
			System.out.println("Nombres: " + nombres);
			System.out.println("Suma edad: " + sumaEdad + "\nMedia edad: " + mediaEdad);
			System.out.println("Suma estatura: " + sumaEstatura + "\nMedia estatura: " + mediaEstatura);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
