package boletin1.ej4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args){
		
		String cad;
		
		Scanner reader = new Scanner(System.in);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tema6\\src\\boletin1\\ej4\\Datos.txt"))) {
			
			System.out.println("Introduce una frase: ");
			cad = reader.nextLine();
			
			while (!cad.equalsIgnoreCase("fin")) {
				bw.write(cad);
				bw.newLine();
				
				System.out.println("Introduce una frase: ");
				cad = reader.nextLine();
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
