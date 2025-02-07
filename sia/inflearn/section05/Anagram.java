package inflearn.section05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 아나그램
 */
public class Anagram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word1 = scanner.nextLine();
		String word2 = scanner.nextLine();

		String answer = solution(word1, word2) ? "YES": "NO";
		System.out.println(answer);

	}

	private static boolean solution(String word1, String word2) {
		Map<Character, Integer> wordMap1 = wordMap(word1);
		Map<Character, Integer> wordMap2 = wordMap(word2);
		return wordMap1.equals(wordMap2);

	}

	private static Map<Character, Integer> wordMap(String word) {
		Map<Character, Integer> wordMap = new HashMap<>();
		for (char c : word.toCharArray()) {
			Integer count = wordMap.getOrDefault(c, 0);
			wordMap.put(c, ++count);
		}

		return wordMap;
	}

}
