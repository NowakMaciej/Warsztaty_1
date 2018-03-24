package Zadanie_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Zgadnij liczbę z zakresu od 0 do 100:");
		int guess = -1;

		boolean flag = true;
		while (flag) {
			try {
				int number = r.nextInt(100)+1;
				guess = sc.nextInt();
				while (guess != number) {
					if (guess > number) {
						System.out.println("Za dużo");
					} else if (guess < number) {
						System.out.println("Za mało");
					}
					guess = sc.nextInt();
				}
				System.out.println("Zgadłeś!");
				sc.close();
				break;
			} catch (InputMismatchException ex) {
				System.out.println("Miała być liczba. Spróbuj od nowa");
				sc.next();
				flag = true;				
			}	
		}
	}
}
