package Zadanie_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		// Podanie liczb i zapisanie ich w tablicy
		/*
		 * Wciąż nie ma warunku na duplikat. Link zawiera przydatne info
		 * https://stackoverflow.com/questions/3951547/java-array-finding-duplicates
		 */
		Scanner sc = new Scanner(System.in);
		int numbersToDraw = 6;
		int[] results = new int[numbersToDraw];
		int nextNumber = -1;
		for (int i = 0; i < results.length; i++) {
			boolean flag = true;
			while (flag) {
				try {
				System.out.println("Podaj " + (i + 1) + ". liczbę całkowitą z zakresu 1-49: ");
				nextNumber = sc.nextInt();
				while (nextNumber <= 0 || nextNumber > 49) {
					System.out.println("Zły input. Podaj liczbę całkowitą z zakresu 1-49");
					nextNumber = sc.nextInt();
				}
				results[i] = nextNumber;
				break;
				} catch (InputMismatchException ex) {
					System.out.print("Zły input. ");
					sc.next();
					flag = true;
				}
			}
		}
		sc.close();
		Arrays.sort(results);
		System.out.println("Twoje liczby:");
		System.out.println(Arrays.toString(results));

		// Losowanie liczb
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		Collections.shuffle(Arrays.asList(arr));
		int[] tab = new int[numbersToDraw];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = arr[i];
		}
		Arrays.sort(tab);
		System.out.println("Wylosowane liczby");
		System.out.println(Arrays.toString(tab));

		// Wyświetlenie wyniku
		int counter = 0;
		for (int i = 0; i < results.length; i++) {
			if (tab[i] == results[i]) {
				counter++;
			}
		}
		if (counter == 3) {
			System.out.println("Brawo! Trafiłeś trójkę!");
		} else if (counter == 4) {
			System.out.println("Brawo! Trafiłeś czwórkę!");
		} else if (counter == 5) {
			System.out.println("Brawo! Trafiłeś piątkę!");
		} else if (counter == 6) {
			System.out.println("Brawo! Trafiłeś szóstkę");
		} else {
			System.out.println("Niestety, nic nie wygrałeś");
		}

	}
	
//	static boolean alreadyExisits ()

}
