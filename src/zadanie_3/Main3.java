package zadanie_3;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max. 10 próbach");
		int min = 0;
		int max = 1000;
		int counter = 0;
		boolean flag = true;
		while (flag) {
			int guess = (max - min) / 2 + min;
			System.out.println("Zgaduję: " + guess + " Zgadłem? Odpowiedz \"tak\" lub \"nie\"");
			String answer1 = sc.nextLine();
			boolean question1 = true;
			while (question1) {
				if (answer1.equals("nie")) {
					System.out.println("Za dużo?");
					String answer2 = sc.nextLine();
					boolean question2 = true;
					while (question2) {
						if (answer2.equals("tak")) {
							question2 = false;
							max = guess;
						} else if (answer2.equals("nie")) {
							System.out.println("Aha, czyli za mało?");
							String answer3 = sc.nextLine();
							boolean question3 = true;
							while (question3) {
								if (answer3.equals("tak")) {
									question3 = false;
									min = guess;
								} else if (answer3.equals("nie")) {
									System.out.println("Nie kłam! Jeszcze raz.");
									counter--;
									question3 = false;
								} else {
									System.out.println("Nie rozumiem. Odpowiedz czy za mało - \"tak\" lub \"nie\"");
									question3 = true;
									answer3 = sc.nextLine();
								}
							}
							question2 = false;
						} else {
							System.out.println("Nie rozumiem. Odpowiedz czy za dużo - \"tak\" lub \"nie\"");
							question2 = true;
							answer2 = sc.nextLine();
						}
					}
					counter++;
					question1 = false;
					flag = true;
				} else if (answer1.equals("tak")) {
					counter++;
					System.out.println("Zgadłem za " + counter + ". razem. Brawo ja!");
					question1 = false;
					flag = false;
				} else {
					System.out.println("Nie rozumiem odpowiedzi. Odpowiedz czy zgadłem - \"tak\" lub \"nie\"");
					answer1 = sc.nextLine();
					question1 = true;
				}
			}
		}
		sc.close();
	}

}
