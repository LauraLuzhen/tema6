package boletin1.ej6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		List<Integer> numeros = new ArrayList<Integer>();
		String cad = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\ej6\\NumerosNoOrdenados.txt"))) {
			cad = br.readLine();
			do {
				numeros.add(Integer.parseInt(cad));
				cad = br.readLine();
			} while (cad != null);
			
			Collections.sort(numeros);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\ej6\\NumerosOrdenados.txt"))) {
			for (int dato: numeros) {
				bw.write(String.valueOf(dato));
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
