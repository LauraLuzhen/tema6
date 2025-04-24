package boletin1.ej8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio8 {

	public static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opc = 0;
		LocalDate fecha;
		double tempMax, tempMin;
		String dato;
		
		final String FICHERO = "src\\boletin1\\ej8\\temperaturas.txt";
		
		do {
			System.out.println();
			menu();
			opc = reader.nextInt();
			reader.nextLine();
			
			switch(opc) {
			case 1 -> {
				System.out.println("Introduce la temperatura máxima: ");
				tempMax = reader.nextDouble();
				System.out.println("Introduce la temperatura mínima: ");
				tempMin = reader.nextDouble();
				
				if (tempMin <= tempMax) {
					fecha = LocalDate.now();
					dato = fecha + ", " + tempMax + ", " + tempMin;
					
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
						bw.write(dato);
						bw.newLine();
						
						bw.flush();
						bw.close();
						System.out.println("Dato enviado");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("La temperatura mínima no puede ser mayor a la máxima");
				}
			}
			case 2 -> {
				try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
					dato = br.readLine();
					
					do {
						System.out.println(dato);
						dato = br.readLine();
					} while (dato != null);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case 0 -> {
				System.out.println("Saliendo del programa...");
			}
			default -> System.out.println("Introduce una opción válida");
			}
			
		} while (opc != 0);
		
		System.out.println("FIN DEL PROGRAMA");
		
		reader.close();
	}
	
	public static void menu() {
		System.out.println("INTRODUCE UNA OPCIÓN: ");
		System.out.println("1. Registra una nueva temperatura");
		System.out.println("2. Mostrar historial de registros");
		System.out.println("0. Salir");
	}
}
