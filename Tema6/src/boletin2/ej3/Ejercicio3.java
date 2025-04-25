package boletin2.ej3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static Scanner reader = new Scanner(System.in);
	public static final String FICHERO = "src\\boletin2\\ej3\\fichero.txt";
	public static int lineaActual = 0;
	
	public static void main(String[] args) {
		
		int opc = 0;
		boolean ficheroFinalizado = false;
		
		do {
			if (!ficheroFinalizado) {
				menu();
				opc = reader.nextInt();
			} else {
				System.out.println("\nEl fichero ha finalizado");
				opc = 0;
			}
			
			switch (opc) {
			case 1 -> ficheroFinalizado = leerLineas();
			case 0 -> System.out.println("Saliendo del programa...");
			default -> System.out.println("Introduce un valor válido");
			}
		} while (opc != 0);
		
		System.out.println("Fin del programa");
		
		reader.close();
	}
	
	public static void menu() {
		System.out.println("\nINTRODUCE UNA OPCIÓN: ");
		System.out.println("1. Leer el fichero");
		System.out.println("0. Salir");
	}
	
	public static boolean leerLineas() {
		final int CANTIDAD = 10;
		String cad = "";
		int cont = 0;
		boolean ficheroFinalizado = false;
		
		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			for (int i = 0; i < lineaActual; i++) {
				br.readLine();
			}
			
			cad = br.readLine();
			while (cont < CANTIDAD && cad != null) {
				System.out.println(cad);
				cad = br.readLine();
				cont++;
			}
			
			if (cad == null) {
				ficheroFinalizado = true;
			}
			
			lineaActual += cont;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ficheroFinalizado;
	}
}
