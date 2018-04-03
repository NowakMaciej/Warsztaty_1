package zadanie_4;


import java.util.Random;
import java.util.Scanner;

/*
 * nie ma żadnego mechanizmu sprawdzania poprawności
 */

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sumOfResuslts = 0;

		System.out.println("Podaj kod kostki w formacie: liczbarzutów/rodzajkostki/modyfikator np. 2D10-10");
		String userInput = sc.nextLine();
		String userInputRefined = userInput.replaceAll("-", "+-");
		String[] results = userInputRefined.split("D|\\+");
		// System.out.println(Arrays.toString(results));
		sc.close();
		// przypisanie liczby rzutów
		int numberOfThrows = 1;
		if (isNumber(results[0]) && (Integer.parseInt(results[0]) > numberOfThrows)) {
			numberOfThrows = Integer.parseInt(results[0]);
		}
		System.out.println("Liczba rzutów: " + numberOfThrows);
		
		// rzut(y) kostką
		int throwResult = 0;
		for (int i = 0; i < numberOfThrows; i++) {
			Random random = new Random();
			throwResult = random.nextInt(Integer.parseInt(results[1]))+1;
			sumOfResuslts += throwResult;
			System.out.println("Rzut " + (i + 1) + ". Wyrzucono: " + throwResult);
		}
		System.out.println("Suma rzutów: " + sumOfResuslts);
		
		// obliczenie ostatecznego rezultatu z uwzględnieniem modyfikatora
		sumOfResuslts += Integer.parseInt(results[2]);
		System.out.println("Wynik (z uwzględnieniem modyfikatora): " + sumOfResuslts);
	}

	static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
