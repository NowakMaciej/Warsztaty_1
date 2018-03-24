package Zadanie_3;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max. 10 próbach");
		Scanner sc = new Scanner(System.in);
		
		
		int min = 0;
		int max = 1000;
		int guess = (max-min)/2 + min;
		System.out.println("Zgaduję: " + guess);
		System.out.println("Zgadłem?");
		if (sc.nextLine().equals("n")){
			System.out.println("Za dużo?");
			if (sc.nextLine().equals("y")){
				max = guess;
			} else {
				System.out.println("Za mało");
				min = guess;
			}	
		} else {
			System.out.println("No zgadłeś");
		}	
	}

}
