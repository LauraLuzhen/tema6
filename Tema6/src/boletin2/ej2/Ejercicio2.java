package boletin2.ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static Scanner reader = new Scanner(System.in);
	public static final String FICHERO = "src\\boletin2\\ej2\\firmas.txt";

	public static void main(String[] args) {

		String nombre;
		boolean haFirmado = false;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			System.out.println("Introduce tu nombre: ");
			nombre = reader.nextLine();

			haFirmado = comprobarFirma(nombre);

			if (haFirmado) {
				System.out.println("Usted ya ha firmado");
			} else {
				bw.write(nombre);
				bw.newLine();
				System.out.println("Firma realizada correctamente");
			}

			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reader.close();
	}

	public static boolean comprobarFirma(String nombre) {
		boolean haFirmado = false;
		String cad = "";

		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			cad = br.readLine();

			while (cad != null && !haFirmado) {
				if (cad.equalsIgnoreCase(nombre)) {
					haFirmado = true;
				}
				cad = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return haFirmado;
	}
}
