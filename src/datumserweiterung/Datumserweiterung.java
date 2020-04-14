package datumserweiterung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Datumserweiterung {

	public static void main(String[] args) throws IOException {
		
		
		int j = 0;
		int m = 0;
		int t = 0;
		int s = 0;
		int m1 = 0;
		int m2 = 0;
		int calculationNumber;
		int modulo;
		int febFactor;
		
		
		
		// Jahreszahl j
		j = getNumber("Jahreszahl", "j", 1600, 3000);
		
		// Monatszahl m
		m = getNumber("Monatszahl", "m", 1, 12);
		
		switch (m) {
		case 2:
			t = getNumber("Tageszahl", "t", 1, 28);
			febFactor = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			t = getNumber("Tageszahl", "t", 1, 30);
			febFactor = 30;
			break;

		default:
			t = getNumber("Tageszahl", "t", 1, 31);
			febFactor = 31;
			break;
		}
		
		// Stundenzahl s
		s = getNumber("Stundenzahl", "s", 0, 23);
		
		// Minutenzahl m1
		m1 = getNumber("Minutenzahl", "m1", 0, 59);
		
		// Minutenzahl m2
		m2 = getNumber("Minutenzahl", "m2", 0, 40000);
		
		/*
		System.out.println("j: " +j);
		System.out.println("m: " +m);
		System.out.println("t: " +t);
		System.out.println("s: " +s);
		System.out.println("m1: " +m1);
		System.out.println("m2: " +m2);
		*/
		
		System.out.println();
		System.out.println("Eingabe:");
		System.out.println(j +" " +m +" " +t +" " +s +" " +m1 +" " +m2);
		System.out.println();
		
		
		// Add the number on top of the given date...
		calculationNumber = m1 + m2;
		m1 = calculationNumber % 60;
		
		calculationNumber = s + calculationNumber / 60;
		s = calculationNumber % 24; 
		
		calculationNumber = t + calculationNumber / 24;
		t = calculationNumber % febFactor; 
		
		calculationNumber = m + calculationNumber / febFactor;
		m = calculationNumber % 12; 
		
		calculationNumber = j + calculationNumber / 12;
		j = calculationNumber; 
		
		
		System.out.println("Ausgabe:");
		System.out.println(j +" " +m +" " +t +" " +s +" " +m1);
		
		
		
// ==============> Methoden <=====================================		

	}

	private static int getNumber(String numberName, String variableName , int min, int max) throws IOException {
		// TODO Auto-generated method stub
			
		boolean numberCorrect = false;
		int number = 0;
		String eingabe;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		while (numberCorrect == false) {

			try {
				System.out.println("Bitte geben Sie eine " +numberName +" " +variableName + " ein ("+min +" <= " +variableName + " <= "+max +"):\n");
				eingabe = br.readLine();
				number = Integer.parseInt(eingabe);
			}

			catch (NumberFormatException ausnahme) {
				System.out.println("Bitte eine Zahl eingeben!");
				continue;
			}
			if (number >= min && number <= max) {
				numberCorrect = true;
			} else {
				System.out.println("Die Zahl ist nicht im richtigen Bereich!");
				numberCorrect = false;
			}
		}
		return number;
	}

}


