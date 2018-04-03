package zadanie_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		// Podanie liczb przez użytkownika i zapisanie ich w tablicy
		Scanner sc = new Scanner(System.in);
		int numbersToDraw = 6;
		ArrayList<Integer> results = new ArrayList<>(numbersToDraw);
		int nextNumber = 0;
		for (int i = 0; i < numbersToDraw; i++) {
			boolean flag = true;
			while (flag) {
				System.out.println("Podaj " + (i + 1) + ". liczbę całkowitą z zakresu 1-49: ");
				if (sc.hasNextInt()) {
					nextNumber = sc.nextInt();
					if (results.contains(nextNumber)) {
						System.out.println("Podana liczba już istnieje");
						flag = true;
					} 
					if (nextNumber < 1 || nextNumber > 49) {
						System.out.println("Zły input. Podaj liczbę całkowitą z zakresu 1-49");
						flag = true;
					} else {
						flag = false;
					}
				} else {
					System.out.println("Zły input. To nie jest liczba");
					sc.next();
					flag = true;
				}	
			}
			results.add(nextNumber);
		}
		sc.close();
		Collections.sort(results);
		System.out.println("Twoje liczby:");
		System.out.println(results);

		// Losowanie liczb przez maszynę losującą
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

		// Porównanie wartości podanych przez użytkownika z wartościami wylosowanymi przez maszynę losującą i wyświetlenie wyniku
		int counter = 0;
		for (int i = 0; i < numbersToDraw; i++) {
			if (tab[i] == results.get(i)) {
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
}
