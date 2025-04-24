package boletin1.ej7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio7 {
	
	public static Map<String, Integer> contactos = new LinkedHashMap<String, Integer>();

	public static void main(String[] args) {
		
		String nombre;
		int telefono;
		int opc;
		
		Scanner reader = new Scanner(System.in);
		
		do {
			System.out.println();
			menu();
			opc = reader.nextInt();
			reader.nextLine();
			
			switch(opc) {
			case 1 -> {
				System.out.println("Introduce el nombre: ");
				nombre = reader.nextLine();
				System.out.println("Introduce el número de teléfono: ");
				telefono = reader.nextInt();
				reader.nextLine();
				
				if (contactos.size() == 20) {
					System.out.println("La agenda está llena");
				} else {
					if (contactos.containsKey(nombre)) {
						System.out.println("El contacto ya se encuentra en la agenda");
					} else {
						System.out.println("Contacto añadido correctamente");
						contactos.put(nombre, telefono);
					}
				}
			}
			case 2 -> {
				System.out.println("Introduce el nombre: ");
				nombre = reader.nextLine();
				
				if (contactos.containsKey(nombre)) {
					System.out.println("Nombre: " + nombre + "\nTeléfono: " + contactos.get(nombre));
				} else {
					System.out.println("El contacto no se encuetra en la agenda");
				}
			}
			case 3 -> {
				for (Map.Entry<String, Integer> entry : contactos.entrySet()) {
				    System.out.println("Nombre " + entry.getKey() + " y teléfono " + entry.getValue());
				}
			}
			case 0 -> {
				System.out.println("Saliendo del programa...");
				enviar();
			}
			default -> System.out.println("Introduce una opción válida");
			}
			
		} while (opc != 0);
		
		System.out.println("FIN DEL PROGRAMA");
		
		reader.close();
	}
	
	public static void enviar() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tema6\\src\\boletin1\\ej7\\agenda.txt", true))) {
			for (Map.Entry<String, Integer> entry : contactos.entrySet()) {
				bw.write("Nombre " + entry.getKey() + " y teléfono " + entry.getValue());
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println("INTRODUCE UNA OPCIÓN: ");
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar nombre");
		System.out.println("3. Mostrar datos");
		System.out.println("0. Salir");
	}
}
