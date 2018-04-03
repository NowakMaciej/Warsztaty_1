package zadanie_5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main5 {
	public static void main(String[] args) throws FileNotFoundException {
		Connection connect = Jsoup.connect("http://www.onet.pl/");
		try {
			Document document = connect.get();
			Elements links = document.select("span.title");

			StringBuilder sb = new StringBuilder();
			PrintWriter pw = new PrintWriter("popular_words.txt");
			for (Element elem : links) {
				sb.append(elem.text()).append(" ");
			}
			int countAllWords = 0;
			String str = sb.toString();
			String[] words = str.split(" ");
			for (String x : words) {
				pw.println(x);
				countAllWords++;
			}
			System.out.println("Liczba wszystkich słów: " + countAllWords);

			PrintWriter pw2 = new PrintWriter("filtered_popular_words.txt");
			ArrayList<String> filteredWords = new ArrayList<>(Arrays.asList(words));
			String[] illegalWords = { "oraz", "ani", "lub", "nie", "chce" };
			int countFilteredWords = 0;
			for (int i = 0; i < filteredWords.size(); i++) {
				for (int j = 0; j < illegalWords.length; j++) {
					if (filteredWords.get(i).length() < 3 || filteredWords.get(i).equals(illegalWords[j])) {
						filteredWords.remove(filteredWords.get(i));
					}
				}
				pw2.println(filteredWords.get(i));
				countFilteredWords++;
			}
			System.out.println("Liczba przefiltrowanych słów: " + countFilteredWords);
			pw.close();
			pw2.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
